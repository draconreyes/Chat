package chat;

public class Lista {
    Proceso raiz = null;
    Proceso ultimo = null;
    public void anadir(Proceso p){
        if(raiz==null){
            raiz = p;
            ultimo = p;
        }
        else{
            ultimo.sig = p;
            ultimo = p;
        }
    }
    
    public void enviarMensa(String le){
        Proceso mover = raiz;
        while(mover!=null){
            mover.enviarMensa(le);
            mover = mover.sig;
        }
    }
    
    public void mostrar(){
        Proceso mover = raiz;
        while(mover!=null){
            mover.mostrar();
            mover = mover.sig;
        }
    }
    
    
}
