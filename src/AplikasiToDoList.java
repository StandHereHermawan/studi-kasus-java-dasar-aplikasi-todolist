public class AplikasiToDoList {

    public static String[] model = new String[10];

    public static void main(String[] args) {
        testRemoveToDoList();
    }

    /*Menampilkan To Do List*/
    public static void showToDoList() {
        for (var i = 0; i < model.length; i++) {
            var todo = model[i];
            var no = i + 1;
            if (todo != null) {
                System.out.println(no + "." + todo);
            }
        }
    }

    /*UnitTestShowToDoList*/
    public static void testShowToDoList() {
        model[0] = "Belajar Java Dasar";
        model[1] = "Studi Kasus Java Dasar : Aplikasi To Do List";
        showToDoList();
    }

    /*Menambah To Do List*/
    public static void addToDoList(String todo) {
        //cek apakah model penuh?
        var isFull = true;
        for (int i = 0; i < model.length; i++) {
            if (model[i] == null) {
                //model masih ada yang kosong
                isFull = false;
                break;
            }
        }

        //Jika penuh, kita resize ukuran Array 2x lipat
        if (isFull) {
            var temp = model;
            model = new String[model.length * 2];
            for (int i = 0; i < temp.length; i++) {
                model[i] = temp[i];
            }
        }

        //tambahkan ke posisi yang data array nya NULL
        for (var i = 0; i < model.length; i++) {
            if (model[i] == null) {
                model[i] = todo;
                break;
            }
        }
    }

    public static void testAddToDoList() {
        for (int i = 0; i < 25; i++) {
            addToDoList("Contoh To Do ke." + i);
        }

        showToDoList();
    }

    /*Menghapus To Do List*/
    public static boolean removeToDoList(Integer number) {
        if ((number - 1) >= model.length) {
            return false;
        }   else if (model[number - 1] == null) {
            return false;
        }   else {
            for (int i = (number - 1); i < model.length; i++) {
                if (i == (model.length -1)) {
                    model[i] = null;
                }else {
                    model[i] = model[i + 1];
                }
            }
            return true;
        }
    }

    public static void testRemoveToDoList() {
        addToDoList("Satu");
        addToDoList("Dua");
        addToDoList("Tiga");
        addToDoList("Empat");
        addToDoList("Lima");
        addToDoList("Enam");
        addToDoList("Tujuh");
        addToDoList("Delapan");

        var result = removeToDoList(8);
        System.out.println(result);

        result = removeToDoList(1);
        System.out.println(result);

        result = removeToDoList(4);
        System.out.println(result);
//
//        result = removeToDoList(5);
//        System.out.println(result);

        showToDoList();
    }

    /*Menampilkan view To Do List*/
    public static void viewShowToDoList() {


    }

    /*Menampilkan view menambahkan To Do List*/
    public static void viewAddToDoList() {


    }

    /*Menampilkan view menghapus To Do List*/
    public static void viewRemoveToDoList() {


    }

}
