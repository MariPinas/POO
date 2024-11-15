using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace $safeprojectname$ {
    internal class Coxinha : Produto{
        bool isVegan;

        public Coxinha(bool isVegan, double p) : base("Coxinha",p){
            this.isVegan = isVegan;
        }
        public override void reajustarPreco(Produto a) {
            preco = preco * 1.15;
        }
    }
}
