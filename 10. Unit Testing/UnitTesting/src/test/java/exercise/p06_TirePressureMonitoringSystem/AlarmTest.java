package exercise.p06_TirePressureMonitoringSystem;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class AlarmTest {
    @Test
    public void test_Alarm_WithLowPressure() {
        // We don't know what value will Sensor return (because it's Random)
        // Mockito helps us what value should Sensor return
        // Otherwise the test might pass or might fail... depends on the randomly generated number
        Sensor sensor = Mockito.mock(Sensor.class);
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(12.0);

        Alarm alarm = new Alarm(sensor);
        alarm.check();

        // Alarm on
        assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void test_Alarm_WithHighPressure() {
        Sensor sensor = Mockito.mock(Sensor.class);
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(100.0);

        Alarm alarm = new Alarm(sensor);
        alarm.check();

        // Alarm on
        assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void test_Alarm_WithNormalPressure() {
        Sensor sensor = Mockito.mock(Sensor.class);
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(20.0);

        Alarm alarm = new Alarm(sensor);
        alarm.check();

        // Alarm off
        assertFalse(alarm.getAlarmOn());
    }
}