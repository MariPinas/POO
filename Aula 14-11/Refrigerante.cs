using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace $safeprojectname$ {
    internal class Refrigerante : Produto{
        String marca;

        public Refrigerante(String marca, double p) : base("Guarana",p) {
            this.marca = marca;
        }

        public override void reajustarPreco(Produto a) {
            preco = preco * 1.01;
        }
    }
}
