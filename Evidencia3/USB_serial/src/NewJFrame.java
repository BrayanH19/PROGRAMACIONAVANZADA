/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import jssc.SerialPort;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;
import java.lang.NullPointerException;
/**
 *
 * @author Bebe
 */
public class NewJFrame extends javax.swing.JFrame   implements SerialPortEventListener {
    static SerialPort serialPort; //Variables para el puerto serial
    static SerialPort serialPort2; //Variables para el puerto serial//
    String NoPort = new String(); //Varibale para alamcenar el nombre del puertop
    String Data = new String();
    //String N;
    /**
     * Creates new form NewJFrameOtroEje3
     */
    public NewJFrame(String NoPort,String Data) { 
        //Data="COM1";
        //NoPort="COM2";
        initComponents();
        System.out.println("Compuertas abiertas =v");
        
        System.out.println(NoPort);
        System.out.println(Data);
        //for(int i=0; i<=5; i++){
        AbrirPuertoSerie(NoPort); //Se recibe el nombre del puerto serial elejido en el otro jFrame y se abre para la 
                                 //comunicación    
        AbrirPuertoSerie2(Data);
        //}
    }
    /*** Método para dejar listo el puerto serial para la recepción y envío de datos ***/
private void AbrirPuertoSerie(String NoPort ) {
    serialPort = new SerialPort(NoPort);  // Crear el objeto 
    try {
      serialPort.openPort();//Abre el puerto serial
      serialPort.setParams(SerialPort.BAUDRATE_9600,  //Configuración del puerto serial
                           SerialPort.DATABITS_8,
                           SerialPort.STOPBITS_1,
                           SerialPort.PARITY_NONE);//Set params. Also you can set params by this string: serialPort.setParams(9600, 8, 1, 0);            
      
      serialPort.setFlowControlMode(SerialPort.FLOWCONTROL_RTSCTS_IN| 
                                  SerialPort.FLOWCONTROL_RTSCTS_OUT);
      
      serialPort.addEventListener(this, SerialPort.MASK_RXCHAR);
      //jTextArea1.append("Hurrah!");
      //serialPort.writeString("Hurrah!");
      jTextArea1.append("Hurrah! abriste las compuertas ;v ");
    }        
   catch (SerialPortException ex) {
      System.out.println(ex);
    } 
}

private void AbrirPuertoSerie2(String Data) {
    serialPort2 = new SerialPort(Data);  // Crear el objeto 
    try {
      serialPort2.openPort();//Abre el puerto serial
      
      serialPort2.setParams(SerialPort.BAUDRATE_9600,  //Configuración del puerto serial
                           SerialPort.DATABITS_8,
                           SerialPort.STOPBITS_1,
                           SerialPort.PARITY_NONE);//Set params. Also you can set params by this string: serialPort.setParams(9600, 8, 1, 0);            
                           
      serialPort2.setFlowControlMode(SerialPort.FLOWCONTROL_RTSCTS_IN | 
                                  SerialPort.FLOWCONTROL_RTSCTS_OUT);
      
      serialPort2.addEventListener(this, SerialPort.MASK_RXCHAR);
                           //serialPort2.writeString("Hurrah!");
                           jTextArea2.append("Hurrah!  abriste las compuertas ;v ");
    }        
   catch (SerialPortException ex) {
      System.out.println(ex);
    } 
    
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);
        jTextArea1.getAccessibleContext().setAccessibleName("");

        jButton2.setText("Close");
        jButton2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);

        jLabel1.setText("Input");

        jLabel2.setText("Output");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(187, 187, 187)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(204, 204, 204))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jTextArea2, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(374, 374, 374)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(72, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextArea2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(155, 155, 155))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

/*** Método para enviar el "1" por el puerto serial ***/
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    System.exit(0);             
    }//GEN-LAST:event_jButton2ActionPerformed
/*** Cuando se cierra el jFrame cierra tambien el puerto serial *///
    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        try {
            serialPort.closePort();
            serialPort2.closePort();
        }        
        catch (SerialPortException ex) {
            System.out.println(ex);
        }         
        System.exit(0);
    }//GEN-LAST:event_formWindowClosed
 /*** Método para detectar cuando llego un dato al puerto serial ***/
    @Override
    public void serialEvent(SerialPortEvent event) {
        if(event.isRXCHAR() && (event.getEventValue()>0)) {
            try { 
                //N=serialPort.readString(); 
                //serialPort2.writeString("Hurrah!");
                jTextArea1.append(serialPort.readString()); // lee el dato del puerto serial y lo va agregando al jTextArea1 
                serialPort2.writeString("Hola ");
                //serialPort2.writeString(N);
                //serialPort2.writeString("Hurrah!");
                jTextArea2.append(serialPort2.readString());
                //serialPort2.writeString("Hurrah!");
                //jTextArea2.append(serialPort.readString());
                //jTextArea2.append("Hurrah!");
                //jTextArea2.append(serialPort.readString());
                //AbrirPuertoSerie2(Data); 
            }
            catch (SerialPortException ex) {
                System.out.println("Error in receiving string from COM-port: " + ex);
                }
            }    
        }
    
    
    
        /**
         * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    // End of variables declaration//GEN-END:variables
  /*
     * In this class must implement the method serialEvent, through it we learn about 
     * events that happened to our port. But we will not report on all events but only 
     * those that we put in the mask. In this case the arrival of the data and change the 
     * status lines CTS and DSR
     */
        
}
