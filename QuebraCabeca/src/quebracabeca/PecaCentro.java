package quebracabeca;

import java.util.ArrayList;
import java.util.List;

public class PecaCentro extends Peca {

    public PecaCentro(Borda b1, Borda b2, Borda b3, Borda b4) {
        super(b1, b2, b3, b4);
    }

    @Override
    public boolean Conectar(Peca peca, int lado) {
        switch (lado) {
            case 0:
                if (this.b1.encaixaCom(b3)) {
                    return true;
                } else {
                    return false;
                }

            case 1:
                if (this.b2.encaixaCom(b4)) {
                    return true;
                } else {
                    return false;
                }
            case 2:
                if (this.b3.encaixaCom(b1)) {
                    return true;
                } else {
                    return false;
                }
            case 3:
                if (this.b4.encaixaCom(b2)) {
                    return true;
                } else {
                    return false;
                }
            default:
                return false;
        }
    }
}
