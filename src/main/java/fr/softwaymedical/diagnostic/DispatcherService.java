package fr.softwaymedical.diagnostic;

import fr.softwaymedical.diagnostic.interpreter.InterpreterService;
import fr.softwaymedical.diagnostic.monitor.MonitorService;
import fr.softwaymedical.diagnostic.sensor.SensorService;

public class DispatcherService {

    private final SensorService sensorService;
    private final InterpreterService interpreterService;
    private final MonitorService monitorService;

    public DispatcherService(
            SensorService sensorService,
            InterpreterService interpreterService,
            MonitorService monitorService
    ) {
        this.sensorService = sensorService;
        this.interpreterService = interpreterService;
        this.monitorService = monitorService;
    }

    public void dispatch() {
        final int healthIndex = sensorService.getHealthIndex();
        final String medicalUnits = interpreterService.getMedicalUnit(healthIndex);
        monitorService.displayDestMedicalUnits(medicalUnits);
    }

}