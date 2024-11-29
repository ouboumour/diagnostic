package fr.softwaymedical.diagnostic.interpreter;

public class InterpreterServiceImpl implements InterpreterService {

    @Override
    public String getMedicalUnit(int healthIndex) {
        return healthIndex % 3 == 0 ? "Cardiologie" : "Traumatologie";
    }

}