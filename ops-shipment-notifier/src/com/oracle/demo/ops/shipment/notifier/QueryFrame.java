/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * QueryFrame.java
 *
 * Created on 16-Aug-2011, 11:52:04
 */
package com.oracle.demo.ops.shipment.notifier;

import com.tangosol.util.Filter;
import com.tangosol.util.filter.AndFilter;

import javax.script.*;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author cmlee
 */
public class QueryFrame extends javax.swing.JFrame implements ActionListener
{

  /**
   * Creates new form QueryFrame
   */
  public QueryFrame()
  {
    initComponents();
    clearButton.addActionListener(this);
    cancelButton.addActionListener(this);
    okayButton.addActionListener(this);
    queryArea.requestFocusInWindow();
    scriptChooser.setFileFilter(new FileFilter()
    {
      @Override
      public boolean accept(File f)
      {
        return (f.isFile() && f.getName().endsWith(".js"));
      }

      @Override
      public String getDescription()
      {
        return ("JavaScript file");
      }
    });
  }

  @Override
  public void actionPerformed(ActionEvent e)
  {
    Object src = e.getSource();
    if(clearButton == src)
    {
      queryArea.setText("");
      return;
    }

    if(okayButton == src)
    {
      processQuery(queryArea.getText().trim());
    }

    setVisible(false);
    dispose();
  }

  private void processQuery(final String q)
  {
    StringBuilder sb = new StringBuilder("importPackage(com.tangosol.util.filter)");
    sb.append("\n").append("importPackage(java.lang)");
    sb.append("\n").append(q);
    System.out.println(sb.toString());
    ScriptEngineManager mgr = new ScriptEngineManager();
    ScriptEngine eng = mgr.getEngineByExtension("js");
    Bindings bindings = eng.getBindings(ScriptContext.ENGINE_SCOPE);
    bindings.put(Constants.FILTER, new AndFilter());
    try
    {
      eng.eval(sb.toString());
    }
    catch(ScriptException ex)
    {
      Logger.getLogger(QueryFrame.class.getName()).log(Level.SEVERE, null, ex);
      return;
    }

    QueryResultFrame f = new QueryResultFrame(Utility.getCache(Constants.SHIPMENT_CACHE)
        , (Filter) bindings.get(Constants.FILTER), continiousQuery.isSelected());
    f.setLocationRelativeTo(null);
    f.setVisible(true);
  }

  /**
   * This method is called from within the constructor to
   * initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is
   * always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents()
  {

    scriptChooser = new javax.swing.JFileChooser();
    jPanel1 = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();
    continiousQuery = new javax.swing.JCheckBox();
    okayButton = new javax.swing.JButton();
    cancelButton = new javax.swing.JButton();
    clearButton = new javax.swing.JButton();
    jScrollPane1 = new javax.swing.JScrollPane();
    queryArea = new javax.swing.JEditorPane();
    jMenuBar1 = new javax.swing.JMenuBar();
    jMenu1 = new javax.swing.JMenu();
    load = new javax.swing.JMenuItem();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setTitle("Query Editor");

    jLabel1.setText("Query ");

    continiousQuery.setText("Continious Query");
    continiousQuery.setToolTipText("Not implemented");
    continiousQuery.setEnabled(false);

    okayButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/oracle/demo/ops/shipment/notifier/tick.png"))); // NOI18N
    okayButton.setText("Okay");

    cancelButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/oracle/demo/ops/shipment/notifier/cross.png"))); // NOI18N
    cancelButton.setText("Cancel");

    clearButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/oracle/demo/ops/shipment/notifier/clear.png"))); // NOI18N
    clearButton.setText("Clear");

    queryArea.setContentType("text/javascript");
    jScrollPane1.setViewportView(queryArea);

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(jLabel1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 406, Short.MAX_VALUE)
                    .addComponent(continiousQuery))
                .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(clearButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 350, Short.MAX_VALUE)
                .addComponent(cancelButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(okayButton)))
            .addContainerGap())
    );

    jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[]{cancelButton, clearButton, okayButton});

    jPanel1Layout.setVerticalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(continiousQuery)
                .addComponent(jLabel1))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(okayButton)
                .addComponent(cancelButton)
                .addComponent(clearButton))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    jMenu1.setText("File");

    load.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/oracle/demo/ops/shipment/notifier/folder.png"))); // NOI18N
    load.setText("Load filter scripts...");
    load.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        loadActionPerformed(evt);
      }
    });
    jMenu1.add(load);

    jMenuBar1.add(jMenu1);

    setJMenuBar(jMenuBar1);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void loadActionPerformed(java.awt.event.ActionEvent evt)
  {//GEN-FIRST:event_loadActionPerformed
// TODO add your handling code here:
    scriptChooser = new JFileChooser();

    int result = scriptChooser.showOpenDialog(this);
    if(JFileChooser.APPROVE_OPTION != result)
    {
      return;
    }
    File f = scriptChooser.getSelectedFile();
    try
    {
      FileReader fr = new FileReader(f);
      BufferedReader br = new BufferedReader(fr);
      StringBuilder sb = new StringBuilder();
      String txt;
      while((txt = br.readLine()) != null)
      {
        sb.append(txt).append(Constants.NEWLINE);
      }
      br.close();
      fr.close();
      queryArea.setText(sb.toString());
    }
    catch(Exception ex)
    {
      Logger.getLogger(QueryFrame.class.getName()).log(Level.SEVERE, null, ex);
    }
  }//GEN-LAST:event_loadActionPerformed

  /**
   * @param args the command line arguments
   */
  public static void main(String args[])
  {
    /* Set the Nimbus look and feel */
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
    * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
    */
    try
    {
      for(javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
      {
        if("Nimbus".equals(info.getName()))
        {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    }
    catch(ClassNotFoundException ex)
    {
      java.util.logging.Logger.getLogger(QueryFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    catch(InstantiationException ex)
    {
      java.util.logging.Logger.getLogger(QueryFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    catch(IllegalAccessException ex)
    {
      java.util.logging.Logger.getLogger(QueryFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    catch(javax.swing.UnsupportedLookAndFeelException ex)
    {
      java.util.logging.Logger.getLogger(QueryFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable()
    {

      public void run()
      {
        new QueryFrame().setVisible(true);
      }
    });
  }
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton cancelButton;
  private javax.swing.JButton clearButton;
  private javax.swing.JCheckBox continiousQuery;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JMenu jMenu1;
  private javax.swing.JMenuBar jMenuBar1;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JMenuItem load;
  private javax.swing.JButton okayButton;
  private javax.swing.JEditorPane queryArea;
  private javax.swing.JFileChooser scriptChooser;
  // End of variables declaration//GEN-END:variables
}
