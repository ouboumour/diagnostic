package fr.softwaymedical.diagnostic.interpreter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InterpreterServiceImplTest {

    private final InterpreterService interpreterService;

    public InterpreterServiceImplTest() {
        this.interpreterService = new InterpreterServiceImpl();
    }

    @Test
    public void givenAMultipleOfThreeButNotFiveHI_whenGettingMedialUnit_thenReturnCardiology() {
        assertEquals("Cardiologie", interpreterService.getMedicalUnit(33));
    }

    @Test
    public void givenAMultipleOfFiveButNotThreeHI_whenGettingMedialUnit_thenReturnTraumatology() {
        assertEquals("Traumatologie", interpreterService.getMedicalUnit(55));
    }

    @Test
    public void givenAMultipleOfBothFiveAndThreeHI_whenGettingMedialUnit_thenReturnBothCardiologyAndTraumatology() {
        assertEquals("Cardiologie, Traumatologie", interpreterService.getMedicalUnit(15));
    }

    @Test
    public void givenANeitherMultipleOfFiveNorThreeHI_whenGettingMedialUnit_thenReturnEmptyString() {
        assertTrue(interpreterService.getMedicalUnit(4).isEmpty());
    }

}