// CruiseControlTest.java
package es.upm.grise.profunduzacion.cruiseController;
import es.upm.grise.profundizacion.cruiseControl.CruiseControl;
import es.upm.grise.profundizacion.cruiseControl.Speedometer;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CruiseControlTest {   
    private CruiseControl cruiseControl;
    private Speedometer speedometer;

    @Test
    void testSetSpeedSet_VelocidadValida() {
        speedometer = new Speedometer();
        cruiseControl = new CruiseControl(speedometer);

        cruiseControl.setSpeedSet(60);
        assertEquals(60, cruiseControl.getSpeedSet());
    }
    @Test
    void testSetSpeedSet_VelocidadNegativa() {
        speedometer = new Speedometer();
        cruiseControl = new CruiseControl(speedometer);
   
        assertThrows(Exception.class, () -> {
            cruiseControl.setSpeedSet(-10);
        });
    }
    @Test
    void testSpeedSet_VelocidadZero() {
        speedometer = new Speedometer();
        cruiseControl = new CruiseControl(speedometer);
       
        assertThrows(Exception.class, () -> {
            cruiseControl.setSpeedSet(0);
        }); 
    }

    @Test
    void testSetSpeedSet_VelocidadSuperiorALimite() {
        speedometer = new Speedometer();
        cruiseControl = new CruiseControl(speedometer);
        cruiseControl.setSpeedLimit(80);
       
        assertThrows(Exception.class, () -> {
            cruiseControl.setSpeedSet(100);
        });
    }
}
