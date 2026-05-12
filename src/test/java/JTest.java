import org.example.Controller.Controller;
import org.example.Model.Operatii;
import org.example.Model.Polinom;
import org.example.View.View;
import org.junit.Test;

import static org.junit.Assert.*;

public class JTest {

    Controller controller = new Controller(new View("Test"));
    Polinom polinom1 = new Polinom(controller.getPolinom("2x^5+x+2"));
    Polinom polinom2 = new Polinom(controller.getPolinom("4x^2+x"));


    @Test
    public void add() throws Exception
    {
        Operatii operatii = new Operatii();
        Polinom result = operatii.Add(polinom1, polinom2);
        assertEquals("2x^5+4x^2+2x+2", result.toString());
        assertEquals("2x+3", result.toString());
    }

    @Test
    public void sub() throws Exception
    {
        Operatii operatii = new Operatii();
        Polinom result = operatii.Subtract(polinom1, polinom2);
        assertEquals("2x^5-4x^2+2", result.toString());
        assertEquals("2x^4+6x+10", result.toString());
    }

    @Test
    public void multiply() throws Exception
    {
        Operatii operatii = new Operatii();
        Polinom result = operatii.Multiply(polinom1, polinom2);
        assertEquals("8x^7+2x^6+4x^3+9x^2+2x", result.toString());
        assertEquals("2x^3+5x+5", result.toString());
    }

    @Test
    public void diff() throws Exception
    {
        Operatii operatii = new Operatii();
        Polinom result1 = operatii.Derivate(polinom1);
        Polinom result2 = operatii.Derivate(polinom2);
        assertEquals("10x^4+1", result1.toString());
        assertEquals("2x^2+1", result2.toString());
    }

    @Test
    public void integrate() throws Exception
    {
        Operatii operatii = new Operatii();
        Polinom result1 = operatii.Integrate(polinom1);
        Polinom result2 = operatii.Integrate(polinom2);
        assertEquals("0.33x^6+0.5x^2+2x", result1.toString());
        assertEquals("0.5x^2+2x", result2.toString());

    }

}

