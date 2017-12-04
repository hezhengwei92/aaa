package net.eoutech.vifi.as.commons.utils;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Created by SUU on 2016/7/29.
 */
public class MyUDPClient {

    private ConfigUtils configUtils = ConfigUtils.getInstance();
    private static MyUDPClient instance = null;
    private DatagramSocket m_socket;
    private String m_serverIP;
    private int m_serverPort;

    private MyUDPClient() {
        m_serverIP = configUtils.getCfgStr( "" );
        m_serverPort = configUtils.getCfgInt( "" );
    }

    public static MyUDPClient getInstance() {
        if ( instance == null ) {
            instance = new MyUDPClient();
        }
        return instance;
    }

    public int sendMsg( String msg ) {

        try {
            m_socket = new DatagramSocket();

            m_socket.setSoTimeout( 3000 );

            byte[] buffer = msg.getBytes();
            DatagramPacket packet = new DatagramPacket( buffer, buffer.length, InetAddress.getByName( m_serverIP ),
                    m_serverPort );
            m_socket.send( packet );

            byte[] b = new byte[ packet.getLength() ];
            DatagramPacket in = new DatagramPacket( b, 0, b.length );
            m_socket.receive( in );


        } catch ( Exception e ) {
            return -1;
        } finally {
            if ( m_socket != null ) {
                m_socket.close();
            }
        }

        return 0;
    }

}
