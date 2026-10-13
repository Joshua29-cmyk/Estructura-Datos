package src.main.java.edu.udelp.list;

public class Main {
    void main (){

        ArrayList<Integer> list = new ArrayList<>(5,2);

        list.add(1);
        imprimir(list);

        list.add(1);
        imprimir(list);

        list.add(2);
        imprimir(list);

        list.add(3);
        imprimir(list);

        list.add(4  );
        imprimir(list);

        list.add(3, 7);
        imprimir(list);

        list.add(-1, 0);

        list.add(5);
        imprimir(list);

        list.add(6);
        imprimir(list);

    }

    public void imprimir(ArrayList<Integer> list){
        try{
            System.out.println("-----------");
            System.out.println(list.toString());
            System.out.println();

        }catch (edu.udelp.Exception.UdelpException e){
            System.out.println(e.getMessage());
        }
    }

}
