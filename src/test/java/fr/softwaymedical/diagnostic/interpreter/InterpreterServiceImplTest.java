package fr.softwaymedical.diagnostic.interpreter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InterpreterServiceImplTest {

    private final InterpreterService interpreterService;

    public InterpreterServiceImplTest() {
        this.interpreterService = new InterpreterServiceImpl();
    }

    @Test
    public void givenAMultipleOfThreeButNotFiveHI_whenGettingMedialUnit_thenReturnCardiology() {
        Assertions.assertEquals("Cardiologie", interpreterService.getMedicalUnit(33));
    }

}