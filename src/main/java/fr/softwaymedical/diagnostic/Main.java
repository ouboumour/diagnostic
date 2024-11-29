package fr.softwaymedical.diagnostic;

import fr.softwaymedical.diagnostic.interpreter.InterpreterService;
import fr.softwaymedical.diagnostic.interpreter.InterpreterServiceImpl;
import fr.softwaymedical.diagnostic.monitor.MonitorService;
import fr.softwaymedical.diagnostic.sensor.SensorService;

import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {

        int healthIndex = ThreadLocalRandom.current().nextInt(1, 101);

        SensorService sensorService = () -> healthIndex;
        MonitorService monitorService = medicalUnits -> {
            System.out.println("HI: " + healthIndex);
            System.out.println("Medical Unit: " + medicalUnits);
        };

        InterpreterService interpreterService = new InterpreterServiceImpl();
        DispatcherService dispatcherService = new DispatcherService(
                sensorService,
                interpreterService,
                monitorService
        );

        dispatcherService.dispatch();
    }

}
