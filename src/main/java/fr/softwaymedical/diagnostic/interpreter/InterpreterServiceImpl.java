package fr.softwaymedical.diagnostic.interpreter;

import java.util.ArrayList;
import java.util.List;

public class InterpreterServiceImpl implements InterpreterService {

    @Override
    public String getMedicalUnit(int healthIndex) {

        List<String> medicalUnits = new ArrayList<>();
        if (healthIndex % 3 == 0) medicalUnits.add("Cardiologie");
        if (healthIndex % 5 == 0) medicalUnits.add("Traumatologie");
        return String.join(", ", medicalUnits);

    }

}