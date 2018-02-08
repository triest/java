
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;



/**
 * Обеспечивает работу программы в режиме сервера
 *
 * @author Влад
 */
public class Server2{
    public static final int Port = 8283;
    VoitingSystem voitingSystem;
    /**
     * Специальная "обёртка" для ArrayList, которая обеспечивает доступ к
     * массиву из разных нитей
     */
    private List<Connection> connections =
            Collections.synchronizedList(new ArrayList<Connection>());
    private ServerSocket server;

    /**
     * Конструктор создаёт сервер. Затем для каждого подключения создаётся
     * объект Connection и добавляет его в список подключений.
     */
    public Server2() {
        try {
            server = new ServerSocket(Port);
            voitingSystem=new VoitingSystem();
            while (true) {
                Socket socket = server.accept();

                // Создаём объект Connection и добавляем его в список
                Connection con = new Connection(socket);
                connections.add(con);
                // Инициализирует нить и запускает метод run(),
                // которая выполняется одновременно с остальной программой
                con.start();

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }
    }


    //  Функция отправки сообщений клиенту
    public void SendToClient(Connection connect,String message){
        connect.out.println(message);
    }

    /**
     * Закрывает все потоки всех соединений а также серверный сокет
     */
    private void closeAll() {
        try {
            server.close();

            // Перебор всех Connection и вызов метода close() для каждого. Блок
            // synchronized {} необходим для правильного доступа к одним данным
            // их разных нитей
            synchronized(connections) {
                Iterator<Connection> iter = connections.iterator();
                while(iter.hasNext()) {
                    ((Connection) iter.next()).close();
                }
            }
        } catch (Exception e) {
            System.err.println("Потоки не были закрыты!");
        }
    }

    /**
     * Класс содержит данные, относящиеся к конкретному подключению:
     * <ul>
     * <li>имя пользователя</li>
     * <li>сокет</li>
     * <li>входной поток BufferedReader</li>
     * <li>выходной поток PrintWriter</li>
     * </ul>
     * Расширяет Thread и в методе run() получает информацию от пользователя и
     * пересылает её другим
     *
     * @author Влад
     */
    private class Connection extends Thread {
        private BufferedReader in;
        private PrintWriter out;
        private Socket socket;
        VoitingSystem voitingSystem;
        private String name = "";

        /**
         * Инициализирует поля объекта и получает имя пользователя
         *
         * @param socket
         *            сокет, полученный из server.accept()
         */
        public Connection(Socket socket) {
            this.socket = socket;
                voitingSystem=new VoitingSystem();
            try {
                in = new BufferedReader(new InputStreamReader(
                        socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

            } catch (IOException e) {
                e.printStackTrace();
                close();
            }
        }

        public void SendToClient(Connection connection,String message){
            connection.out.println(message);
        }

        /**
         * Запрашивает имя пользователя и ожидает от него сообщений. При
         * получении каждого сообщения, оно вместе с именем пользователя
         * пересылается всем остальным.
         *
         * @see java.lang.Thread#run()
         */

/*
        @Override
        public void run() {
            try {
                name = in.readLine();
                // Отправляем всем клиентам сообщение о том, что зашёл новый пользователь
                synchronized(connections) {
                    Iterator<Connection> iter = connections.iterator();
                    while(iter.hasNext()) {
                        ((Connection) iter.next()).out.println(name + " cames now");
                    }
                }

                String str = "";
                while (true) {
                    str = in.readLine();
                    if(str.equals("exit")) break;

                    // Отправляем всем клиентам очередное сообщение
                    synchronized(connections) {
                        Iterator<Connection> iter = connections.iterator();
                        while(iter.hasNext()) {
                            ((Connection) iter.next()).out.println(name + ": " + str);
                        }
                    }
                }

                synchronized(connections) {
                    Iterator<Connection> iter = connections.iterator();
                    while(iter.hasNext()) {
                        ((Connection) iter.next()).out.println(name + " has left");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                close();
            }
        }

        */

        @Override
        public void run(){
            try{
               String namePassword=in.readLine();//защел новый пользователь
                //будем разбивать имя и логин
                String[] parts=namePassword.split("&");
               if(voitingSystem.findUser(parts[0],parts[1])!=null){
                    User user=voitingSystem.findUser(parts[0],parts[1]);//нашли пользователя

               }

            }catch (IOException e){
                e.printStackTrace();
            }finally {
                close();
            }

        }

        /**
         * Закрывает входной и выходной потоки и сокет
         */
        public void close() {
            try {
                in.close();
                out.close();
                socket.close();

                // Если больше не осталось соединений, закрываем всё, что есть и
                // завершаем работу сервера
                connections.remove(this);
                if (connections.size() == 0) {
                    Server2.this.closeAll();
                    System.exit(0);
                }
            } catch (Exception e) {
                System.err.println("Потоки не были закрыты!");
            }
        }

        public void SendToClient(String message){
            this.out.println(message);
        }
    }


}