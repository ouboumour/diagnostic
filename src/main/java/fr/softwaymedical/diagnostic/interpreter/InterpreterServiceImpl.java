package fr.softwaymedical.diagnostic.interpreter;

public class InterpreterServiceImpl implements InterpreterService {

    @Override
    public String getMedicalUnit(int healthIndex) {
        if (healthIndex % 3 == 0)
            return "Cardiologie";
        return  "Traumatologie";
    }

}