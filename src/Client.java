import javafx.scene.paint.Color;

import java.io.*;
import java.net.Socket;

public class Client {
    private Host host;
    private int port;
    private Socket socket = null;
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;
    public Client(Host host) {
        this.host = host;
        this.port = host.getPort();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    socket = new Socket("127.0.0.1", port);
                    System.out.println("connected");
                    dataInputStream = new DataInputStream(socket.getInputStream());
                    dataOutputStream = new DataOutputStream(socket.getOutputStream());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                while (true) {
                        if (Game.turn.getValue().equals(2)) {
                            if (Game.turnNum == 0)
                                Game.start.setValue(true);
                            if (Game.start.getValue()) {
                                if (Game.turnNum == 0) {
                                    try {
                                        dataOutputStream.flush();
                                        dataOutputStream.writeUTF("end");

                                        File file = new File("host.txt");
                                        PrintWriter printWriter = new PrintWriter(file);
                                        printWriter.write("");
                                        printWriter.close();

                                        dataOutputStream.writeUTF(Integer.toString(Game.totScore.getValue()));
                                        int otherScore = Integer.parseInt(dataInputStream.readUTF());
                                        if (Game.totScore.getValue() > otherScore) {
                                            Game.winnerShow.setValue(true);
                                        } else if (Game.totScore.getValue() < otherScore) {
                                            Game.looseShow.setValue(true);
                                        } else {
                                            Game.drawShow.setValue(true);
                                        }
                                        dataOutputStream.flush();
                                        break;
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                                try {
                                    dataOutputStream.flush();
                                    dataOutputStream.writeUTF("start");
                                    dataOutputStream.writeUTF(Game.wordGame.getValue());
                                    Game.start.setValue(false);
                                    dataOutputStream.flush();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            } else if (Game.stop.getValue()) {
                                try {
                                    dataOutputStream.flush();
                                    dataOutputStream.writeUTF("stop");
                                    dataOutputStream.writeUTF(Game.catagories[0].getValue());
                                    dataOutputStream.writeUTF(Game.catagories[1].getValue());
                                    dataOutputStream.writeUTF(Game.catagories[2].getValue());
                                    dataOutputStream.writeUTF(Game.catagories[3].getValue());
                                    dataOutputStream.writeUTF(Game.catagories[4].getValue());

                                    Game.otherCatagories[0] = dataInputStream.readUTF();
                                    Game.otherCatagories[1] = dataInputStream.readUTF();
                                    Game.otherCatagories[2] = dataInputStream.readUTF();
                                    Game.otherCatagories[3] = dataInputStream.readUTF();
                                    Game.otherCatagories[4] = dataInputStream.readUTF();

                                    Word.giveScore();

                                    Game.turnNum--;

                                    Game.stop.setValue(false);
                                    Game.turn.setValue(1);
                                    dataOutputStream.flush();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        } else {
                            try {
                                dataOutputStream.flush();
                                String in = dataInputStream.readUTF();
                                if (in.equals("start")) {
                                    Game.start.setValue(true);
                                    Game.wordGame.setValue(dataInputStream.readUTF());
                                } else if (in.equals("stop")) {
                                    Game.otherCatagories[0] = dataInputStream.readUTF();
                                    Game.otherCatagories[1] = dataInputStream.readUTF();
                                    Game.otherCatagories[2] = dataInputStream.readUTF();
                                    Game.otherCatagories[3] = dataInputStream.readUTF();
                                    Game.otherCatagories[4] = dataInputStream.readUTF();

                                    dataOutputStream.writeUTF(Game.catagories[0].getValue());
                                    dataOutputStream.writeUTF(Game.catagories[1].getValue());
                                    dataOutputStream.writeUTF(Game.catagories[2].getValue());
                                    dataOutputStream.writeUTF(Game.catagories[3].getValue());
                                    dataOutputStream.writeUTF(Game.catagories[4].getValue());

                                    Word.giveScore();

                                    Game.turnNum--;

                                    Game.turn.setValue(2);
                                    Game.start.setValue(false);
                                    Game.stop.setValue(false);
                                    dataOutputStream.flush();
                                } else if (in.equals("end")) {
                                    int otherScore = Integer.parseInt(dataInputStream.readUTF());
                                    dataOutputStream.flush();
                                    dataOutputStream.writeUTF(Integer.toString(Game.totScore.getValue()));
                                    if (Game.totScore.getValue() > otherScore) {
                                        Game.winnerShow.setValue(true);
                                    } else if (Game.totScore.getValue() < otherScore) {
                                        Game.looseShow.setValue(true);
                                    } else {
                                        Game.drawShow.setValue(true);
                                    }
                                    dataOutputStream.flush();
                                    break;
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
