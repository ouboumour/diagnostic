package fr.softwaymedical.diagnostic;

import fr.softwaymedical.diagnostic.interpreter.InterpreterService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DispatcherServiceTest {

    @Mock private SensorService sensorServiceMock;
    @Mock private InterpreterService interpreterServiceMock;
    @Mock private MonitorService monitorServiceMock;

    @InjectMocks
    private DispatcherService dispatcherService;

    @Test
    void testDispatch() {
        int mockHealthIndex = 15;
        String mockMedicalUnits = "Cardiologie, Traumatologie";

        when(sensorServiceMock.getHealthIndex()).thenReturn(mockHealthIndex);
        when(interpreterServiceMock.getMedicalUnit(mockHealthIndex)).thenReturn(mockMedicalUnits);

        dispatcherService.dispatch();

        verify(sensorServiceMock, times(1)).getHealthIndex();
        verify(interpreterServiceMock, times(1)).getMedicalUnit(mockHealthIndex);
        verify(monitorServiceMock, times(1)).displayDestMedicalUnits(mockMedicalUnits);
    }

}