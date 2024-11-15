using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace $safeprojectname$ {
    internal class Leite : Produto{
        String tipo;

        public Leite(String tipo, double p):base("Leite",p) {
            this.tipo = tipo;
        }

        public override void reajustarPreco(Produto a) {
            preco = preco * 1.005;
        }
    }
}
