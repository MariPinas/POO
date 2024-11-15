using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace $safeprojectname${
    internal class Program{
        static void Main(string[] args){
            Console.WriteLine("====BOLACHA NORMAL====");
            Produto b1 = new Bolacha("Trakinas",100);
            b1.exibirProduto();
            Console.WriteLine("====BOLACHA COM REAJUSTE 1====");
            b1.reajustarPreco(b1);
            b1.exibirProduto();
            Console.WriteLine("====BOLACHA COM REAJUSTE 2 ====");
            b1.reajustarPreco(b1);
            b1.exibirProduto();


        }
    }
}
