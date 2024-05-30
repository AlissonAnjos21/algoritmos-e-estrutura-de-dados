package com.alisson.estruturadados.uesb.implementacoes.arvores.metodoremover;

//essa versao da classe Node<T> utililiza as classes pilhas e filas do proprio java.
import java.util.LinkedList;//lista encadeada do java, usada na pilha e na fila
import java.util.Queue;//fila
import java.util.Stack;//pilha

public class Node<T> {

    private T valor;   /* Valor armazenado na raiz. */
    private Node<T> filho_esq, filho_dir; /* Referências para sub-árvores. */

    /*contruir os metodos da arvore
     * - construtor
     * - inserir
     * - imprimir a arvore
     *    - Em profundidade InOrdem
     *    - Em profundidade PreOrdem     *
     *    - Em profundidade PosOrdem
     *    - Em largura
     * - pesquisarProfundidadeInOrdem
     * - pesquisarProfundidadePreOrdem
     * - pesquisarProfundidadePosOrdem
     * - pesquisarEmLargura
     * - remover
     *
     *
     *  calcular o comprimento do caminho entre dois nodes
     *  calcular a altura de um node
     *  verificar se um node eh interno ou externo
     *  calcular a profundidade de um node
     */

    //construtor da arvore sem subarvore
    public Node(T v){
        valor = v;
        filho_esq = null;
        filho_dir = null;
    }

    //fornecendo as subarvores no construtor
    public Node(T v, Node<T> NoEsq, Node<T> NoDir){
        valor = v;
        filho_esq = NoEsq;
        filho_dir = NoDir;
    }

    // retorna o conteudo ou valor do no da arvore
    public T getValor(){
        return valor;
    }


    // Retorna a sub-árvore esquerda
    public Node<T> getFilho_esq() {
        return filho_esq;
    }

    // Retorna a sub-árvore direita
    public Node<T> getFilho_dir() {
        return filho_dir;
    }

    // seta o valor do no raiz da arvore
    public void setValor(T v){
        valor = v;
    }

    //seta o no da subarvore esquerda
    public void setEsq(Node<T> f_esq){
        filho_esq = f_esq;
    }

    //seta o no da subarvore direita
    public void setDir(Node<T> f_dir){

        filho_dir = f_dir;

    }

    public boolean inserirOrdenado(T v) {
        if (v.toString().compareTo(this.getValor().toString())<0) {
            //o valor deve ser inserido a esquerda do no atual
            if (this.getFilho_esq()!=null)
                return this.getFilho_esq().inserirOrdenado(v);//senao for nulo continua navegando na arvore ate encontrar uma folha
            else {
                Node<T> n = new Node<T>(v);//se for nulo, cria o no e adiciona na folha
                this.setEsq(n);
                return true;
            }
        }
        else{
            //o valor deve ser inserido a direita atual
            if (this.getFilho_dir()!=null)
                return this.getFilho_dir().inserirOrdenado(v);
            else {
                Node<T> n = new Node<T>(v);
                this.setDir(n);
                return true;
            }
        }

    }

    protected void imprimeInOrdem() {

        if (this.getFilho_esq()!=null) {
            this.getFilho_esq().imprimeInOrdem();
        }

        System.out.print(this.valor + " "); //visitando o no raiz

        if (this.getFilho_dir()!=null) {
            this.getFilho_dir().imprimeInOrdem();
        }


    }
    protected void imprimeInOrdem2() {

        if (this.getFilho_dir()!=null) {
            this.getFilho_dir().imprimeInOrdem2();
        }

        System.out.print(this.valor + " "); //visitando o no raiz

        if (this.getFilho_esq()!=null) {
            this.getFilho_esq().imprimeInOrdem2();
        }


    }

    protected void imprimeEmPreordem() {

        System.out.print(this.valor + " "); //visitando o no raiz

        if (this.getFilho_esq()!=null) {
            this.getFilho_esq().imprimeEmPreordem();
        }
        if (this.getFilho_dir()!=null) {
            this.getFilho_dir().imprimeEmPreordem();
        }
    }

    protected void imprimeEmPosordem() {

        if (this.getFilho_esq()!=null) {
            this.getFilho_esq().imprimeEmPosordem();
        }
        if (this.getFilho_dir()!=null) {
            this.getFilho_dir().imprimeEmPosordem();
        }

        System.out.print(this.valor + " "); //visitando o no raiz


    }

    protected void imprimeEmLargura() {
        //usaremos uma fila
        Queue<Object> f = new LinkedList<Object>();
        f.offer(this); //enfileira o objeto node que chamou o metodo imprimiremLargura
        while( f.peek()!=null) { //enquanto fila nao estiver vazia repita
            Node<T>  no = (Node<T>)f.poll();//desenfileira um node da fila

            if (no.getFilho_esq()!=null) {
                f.offer(no.getFilho_esq());//se tiver filho da esquerda, enfileira
            }
            if (no.getFilho_dir()!=null) {
                f.offer(no.getFilho_dir());//se tiver filho da direita, enfileira
            }

            System.out.print(no.getValor()+ " ");


        }//while
    }//imprimelargura

    protected void imprimeEmLarguraRecursivo(Queue f) {
        if (f.peek()!=null) //verifica se a fila nao está vazia
        {
            Node<T>  no = (Node<T>)f.poll();

            if (no!=null) {
                if (no.getFilho_esq()!=null) {
                    f.offer(no.getFilho_esq());
                }
                if (no.getFilho_dir()!=null) {
                    f.offer(no.getFilho_dir());
                }
                System.out.print(no.getValor()+" ");
                this.imprimeEmLarguraRecursivo(f);
            }
        }
    }


    protected void imprimeEmLarguraInvertido(){

        Queue<Object> f = new LinkedList<Object>();
        //PilhaEncadeada p = new PilhaEncadeada();
        java.util.Stack  p = new Stack<String>();

        f.offer(this);
        while( f.peek()!=null) {
            Node<T>  no = (Node<T>)f.poll();

            if (no.getFilho_esq()!=null) {
                f.offer(no.getFilho_esq());;
            }
            if (no.getFilho_dir()!=null) {
                f.offer(no.getFilho_dir());
            }

            p.push(no.getValor().toString());
            //System.out.print(no.getValor()+ " ");

        }//while

        System.out.println();
        imprimePilha(p);

    }

    private void imprimePilha(java.util.Stack p) {

        while (!p.empty()) {

            System.out.print(p.pop()+" ");
        }
    }

    protected int calculaAltura() {
//comprimento do caminho mais longo do nó a uma folha.
        int alturaesquerda=0;
        int alturadireita=0;

        if (this.getFilho_esq()!=null)
            alturaesquerda = this.getFilho_esq().calculaAltura()+1;

        //aqui, como vou saber a altura do filho da direita pra eu poder calcular a altura do node

        if (this.getFilho_dir()!=null)
            alturadireita = this.getFilho_dir().calculaAltura()+1;


        if (alturaesquerda>alturadireita)
            return alturaesquerda;

        else
            return alturadireita;
    }
    //ate aqui

    protected int calculaAlturaEmLargura() {

        Queue<Object> f = new LinkedList<Object>();
        Queue<Integer> dist = new LinkedList<Integer>();

        f.offer(this);
        dist.offer(0);

        int altura_maxima = 0;

        while(f.peek()!=null) {
            Node<T>  no = (Node<T>)f.poll();
            int dist_pai = (int) dist.poll();

            if (no.getFilho_esq()!=null) {
                f.offer(no.getFilho_esq());
                dist.offer(dist_pai + 1);
            }

            if (no.getFilho_dir()!=null) {
                f.offer(no.getFilho_dir());
                dist.offer(dist_pai + 1);
            }

            // eh folha
            if (dist_pai > altura_maxima) altura_maxima = dist_pai;
        }//while

        return altura_maxima;
    }//imprimelargura

    protected Node<T> pesquisarValor(T v) {

        int comparacao = v.toString().compareTo(this.getValor().toString());

        if (comparacao<0) {//o valor a ser pesquisado estah do lado esquerdo do node?
            if (this.getFilho_esq()!=null)
                return this.getFilho_esq().pesquisarValor(v); // o valor pode estah na arvore esquerda
            else return null;//valor nao foi encontrado
        }
        else if (comparacao>0) {
            if (this.getFilho_dir()!=null)
                return this.getFilho_dir().pesquisarValor(v); // o valor pode estah na arvore direita
            else return null;//valor nao foi encontrado
        }
        else return this;// o valor encontra-se nesse noh atual

    }

    protected int calculaTotalNodes() {
        int totalesq=0;
        int totaldir=0;

        if (this.getFilho_esq()!=null) {
            totalesq = this.getFilho_esq().calculaTotalNodes();
        }
        if (this.getFilho_dir()!=null) {
            totaldir = this.getFilho_dir().calculaTotalNodes();
        }

        return totalesq+totaldir + 1;
    }

    protected int calculaTotalNodesFolhas() {

        int totalesq=0;
        int totaldir=0;
        boolean ehfolha=true;

        if (this.getFilho_esq()!=null) {
            totalesq = this.getFilho_esq().calculaTotalNodesFolhas();
            ehfolha = false;
        }
        if (this.getFilho_dir()!=null) {
            totaldir = this.getFilho_dir().calculaTotalNodesFolhas();
            ehfolha = false;
        }
        if (ehfolha) { return 1;}
        else return (totaldir + totalesq);
    }

    protected Node<T> NodeComMaiorValor() {
        if (this.getFilho_dir()!= null) {
            return this.getFilho_dir().NodeComMaiorValor();
        }
        else return this;
    }//fim algotimo

    protected Node<T> NodeComMenorValor() {
        if (this.getFilho_esq()!= null) {
            return this.getFilho_esq().NodeComMenorValor();
        } else return this;
    }//fim algotimo

    protected Node<T> acharPai(Node<T> nofilho) {
    /*
       Esse algoritmo retorna o pai do Node noFilho
       O algoritmo verifica se o node do contexto de execução do metodo
       node This eh pai (pela esquerda ou pela direita) do nofilho.
 */

        if (this.getFilho_esq() == nofilho || this.getFilho_dir() == nofilho) {
            return this;
        } else {
            if (nofilho.getValor().toString().compareTo(this.getValor().toString()) > 0) {
                //o valor do no do atual contexto é maior que o nofilho, entao o pai estah do lado direito
                if (this.getFilho_dir() != null) {
                    return this.getFilho_dir().acharPai(nofilho);
                } else {
                    return null;//pode ser que o nofilho nao esta na arvore ou ele eh o no raiz
                }
            } else if(nofilho.getValor().toString().compareTo(this.getValor().toString()) < 0) {// subarvore esquerda
                if (this.getFilho_esq() != null) {
                    return this.getFilho_esq().acharPai(nofilho);
                } else {
                    return null; //pode ser que o nofilho nao esta na arvore ou ele eh o no raiz
                }
            }
            return null;
        }
    }

   protected boolean remover(T v, Node<T> pai){ //inicio do remover
       if(pai == null){
           return false;
       }
        int comparacaoDesseValorComV = this.getValor().toString().compareTo(v.toString());
        if(comparacaoDesseValorComV > 0){ //inicio da busca do node pela esquerda
            if(this.getFilho_esq() != null){
                return this.getFilho_esq().remover(v, pai);
            }else{
                return false;
            }
        }else if(comparacaoDesseValorComV < 0){ //fim da busca do node pela esquerda e inicio da busca do node pela direta
            if(this.getFilho_dir() != null){
                return this.getFilho_dir().remover(v, pai);
            }else{
                return false;
            }
        }else{ // fim da busca do node pela direita / caso onde esse eh o node com o valor buscado
            if(this.getFilho_esq() == null && this.getFilho_dir() == null){ //nao tem filhos
                if(pai.getFilho_esq().equals(this)){
                    pai.filho_esq = null;
                    return true;
                }
                if(pai.getFilho_dir().equals(this)){
                    pai.filho_dir = null;
                    return true;
                }
                return false;
            }else if(this.getFilho_esq() != null && this.getFilho_dir() != null){ //tem dois filhos
                Node<T> menorDireita = this.getFilho_dir();
                while(menorDireita.getFilho_esq() != null){ //pega o menor a direita
                    menorDireita = menorDireita.getFilho_esq();
                }
                Node<T> paiMenorDireita = this.acharPai(menorDireita);

                //tem que fazer essa verificacao para caso o menor filho a direita for imediatamente o proximo valor:
                if(paiMenorDireita.getFilho_dir().getValor().equals(menorDireita.getValor())){
                    paiMenorDireita.filho_dir = null;
                }else{
                    paiMenorDireita.filho_esq = null;
                }
                if(menorDireita.getFilho_dir() == null){
                    menorDireita.filho_esq = this.getFilho_esq();
                    menorDireita.filho_dir = this.getFilho_dir();

                    if(pai.getFilho_esq().getValor().equals(this.getValor())){
                        pai.filho_esq = menorDireita;
                        return true;
                    }
                    if(pai.getFilho_dir().getValor().equals(this.getValor())){
                        pai.filho_dir = menorDireita;
                        return true;
                    }
                    return false;
                }
                if(menorDireita.getFilho_dir() != null){
                    Node<T> descendenteMaisDireita = menorDireita.getFilho_dir();
                    while(descendenteMaisDireita.getFilho_dir() != null){ //pega o descendente mais a direita
                        descendenteMaisDireita = descendenteMaisDireita.getFilho_dir();
                    }
                    descendenteMaisDireita.filho_dir = this.getFilho_dir();
                    menorDireita.filho_esq = this.getFilho_esq();
                    if(pai.getFilho_esq().getValor().equals(this.getValor())){
                        pai.filho_esq = menorDireita;
                        return true;
                    }
                    if(pai.getFilho_dir().getValor().equals(this.getValor())){
                        pai.filho_dir = menorDireita;
                        return true;
                    }
                    return false;
                }
                return false;
            }else{ //tem filho em um dos dois lados
                if(this.getFilho_esq() != null){
                    if(pai.getFilho_esq().getValor().equals(this.getValor())){
                       pai.filho_esq = this.getFilho_esq();
                       return true;
                    }
                    if(pai.getFilho_dir().getValor().equals(this.getValor())){
                        pai.filho_dir = this.getFilho_esq();
                        return true;
                    }
                    return false;
                }
                if(this.getFilho_dir() != null){
                    if(pai.getFilho_esq().getValor().equals(this.getValor())){
                        pai.filho_esq = this.getFilho_dir();
                        return true;
                    }
                    if(pai.getFilho_dir().getValor().equals(this.getValor())){
                        pai.filho_dir = this.getFilho_dir();
                        return true;
                    }
                    return false;
                }
                return false;
            }
        } //fim do caso onde esse era o valor buscado
   } //fim do remover

}



