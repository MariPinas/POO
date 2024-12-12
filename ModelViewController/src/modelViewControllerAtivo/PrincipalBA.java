/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelViewControllerAtivo;

/**
 *
 * @author aluno
 */
public class PrincipalBA {

    public static void main(String[] args) {
        ModelBA m = new ModelBA();
        ViewBA v = new ViewBA();
        ControllerBA c = new ControllerBA();
        c.liga(v, m);
        m.update("Hello World!!");
        System.out.println(""); //psvm cntrl space enter e essa sot cntrl espaco enter
    }
}
