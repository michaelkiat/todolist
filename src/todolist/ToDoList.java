package todolist;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import java.util.LinkedList;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ToDoList {

    static LinkedList<Task> taskList = new LinkedList<Task>();

    static ToDoListGUI mainGUI;

    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
        }

        try {
            taskList = Task.loadTaskList();
        } catch (Exception e) {

        }
        AddTaskGUI addtaskGUI;
        SettingGUI settingGUI;

        mainGUI = new ToDoListGUI();
        addtaskGUI = new AddTaskGUI();
        settingGUI = new SettingGUI();

        loadGUI();
        mainGUI.setVisible(true);

        mainGUI.btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //show add task GUI
                addtaskGUI.setVisible(true);

            }

        });

        addtaskGUI.btnAddTask.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //add task 
                try {
                    if (!new Date(addtaskGUI.jDateChooser1.getDate().getTime()).toLocalDate().isBefore(LocalDate.now())) {
                        taskList.add(new Task(new Date(addtaskGUI.jDateChooser1.getDate().getTime()).toLocalDate(), addtaskGUI.jTextArea1.getText(), false));
                        addtaskGUI.jTextArea1.setText("");
                        addtaskGUI.setVisible(false);
                        loadGUI();

                        try {
                            Task.updateTaskList(taskList);
                        } catch (Exception e) {

                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid Date!");

                    }
                    addtaskGUI.setVisible(false);
                } catch (Exception ea) {

                }
            }

        });
        //Display setting function
        mainGUI.btnSetting.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                settingGUI.setVisible(true);

            }

        });
        //change BG colour to yellow
        settingGUI.btnyellow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                addtaskGUI.jPanel1.setBackground(new Color(255, 255, 204));
                addtaskGUI.jPanel2.setBackground(new Color(255, 255, 127));

                mainGUI.jPanel4.setBackground(new Color(255, 255, 204));
                mainGUI.btnAdd.setBackground(new Color(255, 255, 127));
                mainGUI.btnSetting.setBackground(new Color(255, 255, 127));
                mainGUI.jPanel2.setBackground(new Color(255, 255, 127));
            }

        });
        //change BG colour to green
        settingGUI.btngreen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                addtaskGUI.jPanel1.setBackground(new Color(220, 255, 204));
                addtaskGUI.jPanel2.setBackground(new Color(169, 255, 127));

                mainGUI.jPanel4.setBackground(new Color(220, 255, 204));
                mainGUI.btnAdd.setBackground(new Color(169, 255, 127));
                mainGUI.btnSetting.setBackground(new Color(169, 255, 127));
                mainGUI.jPanel2.setBackground(new Color(169, 255, 127));
            }

        });
        //change BG colour to blue
        settingGUI.btnblue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                addtaskGUI.jPanel1.setBackground(new Color(204, 246, 255));
                addtaskGUI.jPanel2.setBackground(new Color(127, 233, 255));

                mainGUI.jPanel4.setBackground(new Color(204, 246, 255));
                mainGUI.btnAdd.setBackground(new Color(127, 233, 255));
                mainGUI.btnSetting.setBackground(new Color(127, 233, 255));
                mainGUI.jPanel2.setBackground(new Color(127, 233, 255));
            }

        });
        //change BG colour to purple
        settingGUI.btnpurple.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                addtaskGUI.jPanel1.setBackground(new Color(204, 192, 240));
                addtaskGUI.jPanel2.setBackground(new Color(165, 127, 255));

                mainGUI.jPanel4.setBackground(new Color(204, 192, 240));
                mainGUI.btnAdd.setBackground(new Color(165, 127, 255));
                mainGUI.btnSetting.setBackground(new Color(165, 127, 255));
                mainGUI.jPanel2.setBackground(new Color(165, 127, 255));
            }

        });
        //change BG colour to orange
        settingGUI.btnorange.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                addtaskGUI.jPanel1.setBackground(new Color(255, 212, 153));
                addtaskGUI.jPanel2.setBackground(new Color(255, 180, 76));

                mainGUI.jPanel4.setBackground(new Color(255, 212, 153));
                mainGUI.btnAdd.setBackground(new Color(255, 180, 76));
                mainGUI.btnSetting.setBackground(new Color(255, 180, 76));
                mainGUI.jPanel2.setBackground(new Color(255, 180, 76));
            }

        });
        //change BG colour to red
        settingGUI.btnred.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                addtaskGUI.jPanel1.setBackground(new Color(255, 204, 204));
                addtaskGUI.jPanel2.setBackground(new Color(255, 127, 127));

                mainGUI.jPanel4.setBackground(new Color(255, 204, 204));
                mainGUI.btnAdd.setBackground(new Color(255, 127, 127));
                mainGUI.btnSetting.setBackground(new Color(255, 127, 127));
                mainGUI.jPanel2.setBackground(new Color(255, 127, 127));
            }

        });
    }

    private static class deleteBtnEvent implements ActionListener {

        //deleteTask
        @Override
        public void actionPerformed(ActionEvent ae) {
            taskList.remove(Integer.parseInt(((JButton) ae.getSource()).getName()));
            loadGUI();

            try {
                Task.updateTaskList(taskList);
            } catch (Exception e) {

            }
        }
    }

    static void loadGUI() {
        //refresh GUI
        GridBagConstraints c = new GridBagConstraints();
        mainGUI.jPanel4.removeAll();
        JPanel taskPanel = new JPanel();
        taskPanel.setLayout(new GridBagLayout());
        for (int i = 0; i < taskList.size(); i++) {
            JPanel p = new JPanel(new FlowLayout(FlowLayout.LEADING));
            ImageIcon water = new ImageIcon("icon/ic_delete_forever_black_24dp_1x.png");
            p.setBackground(TaskDurationToRGB.dateToColor(taskList.get(i).getDate()));
            SimpleDateFormat sdf = new SimpleDateFormat("dd MMM", Locale.getDefault());

            String date = sdf.format(java.sql.Date.valueOf(taskList.get(i).getDate()));
            JButton btn = new JButton(water);
            btn.setName(String.valueOf(i));
            btn.setContentAreaFilled(false);
            JLabel txt;
            if (taskList.get(i).getStatus()) {
                txt = new JLabel("<html><b>" + date + "</b>&emsp;&emsp;<strike>" + taskList.get(i).getDescription()
                        + "</strike></html>");
            } else {
                txt = new JLabel("<html><b>" + date + "</b>&emsp;&emsp;" + taskList.get(i).getDescription() + "</html>");
            }
            p.add(btn);
            p.add(txt);
            txt.setName(String.valueOf(i));
            txt.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    int n = Integer.parseInt(((JLabel) e.getSource()).getName());
                    Task tempTask = taskList.get(n);
                    tempTask.setStatus(!tempTask.getStatus());
                    taskList.set(n, tempTask);
                    try {
                        Task.updateTaskList(taskList);
                    } catch (Exception ex) {

                    }
                    loadGUI();
                }
            });
            c.anchor = GridBagConstraints.FIRST_LINE_START;
            c.gridx = 0;
            c.gridy = i;
            c.weightx = 1;
            c.insets = new Insets(5, 5, 5, 5);
            c.fill = GridBagConstraints.HORIZONTAL;
            taskPanel.add(p, c);
            taskPanel.setOpaque(false);
            btn.addActionListener(new deleteBtnEvent());
        }
        c.gridx = 0;
        c.gridy = 0;
        mainGUI.jPanel4.add(taskPanel, c);
        c.gridy = 1;
        c.weightx = 1;
        c.weighty = 1;
        c.fill = GridBagConstraints.BOTH;
        JPanel emptySpace = new JPanel();
        emptySpace.setOpaque(false);
        mainGUI.jPanel4.add(emptySpace, c);

        mainGUI.revalidate();
        mainGUI.repaint();
    }
}
