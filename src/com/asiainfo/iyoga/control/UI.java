package com.asiainfo.iyoga.control;

import com.asiainfo.iyoga.bean.Card;
import com.asiainfo.iyoga.bean.Member;
import com.asiainfo.iyoga.serviceImpl.CardServiceImpl;
import com.asiainfo.iyoga.serviceImpl.MemberServiceImpl;
import com.asiainfo.iyoga.serviceImpl.OpenServiceImpl;
import com.mysql.jdbc.log.Log;
import com.mysql.jdbc.log.LogFactory;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by tcgogogo on 16/8/10.
 */
public class UI {
    private static String name;
    private static String address;
    private static String job;
    private static String type;
    private static String startTime;
    private static String endTime;
    private static int times;
    private static String userOption = "";
    private static String cardOption = "";

    private static Logger logger = Logger.getLogger(UI.class);

    public static void show() throws SQLException {
        logger.info("show start");
        JFrame frame = new JFrame("操作");
        frame.setLayout(null);
        frame.setSize(400, 350);

        JRadioButton addMemberButton = new JRadioButton("iyoga add-member");
        addMemberButton.setBounds(25, 50, 200, 25);
        frame.add(addMemberButton);

        JLabel addMemberNameLable = new JLabel("姓名:");
        addMemberNameLable.setBounds(50, 80, 30, 25);
        frame.add(addMemberNameLable);

        JTextField addMemberNameText = new JTextField();
        addMemberNameText.setBounds(80, 80, 60, 25);
        frame.add(addMemberNameText);

        JLabel addMemberAddressLable = new JLabel("住址:");
        addMemberAddressLable.setBounds(150, 80, 30, 25);
        frame.add(addMemberAddressLable);

        JTextField addMemberAddressText = new JTextField();
        addMemberAddressText.setBounds(180, 80, 60, 25);
        frame.add(addMemberAddressText);

        JLabel addMemberJobLable = new JLabel("工作:");
        addMemberJobLable.setBounds(250, 80, 30, 25);
        frame.add(addMemberJobLable);

        JTextField addMemberJobText = new JTextField();
        addMemberJobText.setBounds(280, 80, 60, 25);
        frame.add(addMemberJobText);

        JRadioButton addCardButton = new JRadioButton("iyoga add-card");
        addCardButton.setBounds(25, 120, 200, 25);
        frame.add(addCardButton);

        JLabel addCardNameTable = new JLabel("姓名:");
        addCardNameTable.setBounds(50, 150, 30, 25);
        frame.add(addCardNameTable);

        JTextField addCardNameText = new JTextField();
        addCardNameText.setBounds(80, 150, 60, 25);
        frame.add(addCardNameText);

        JRadioButton yearCardButton = new JRadioButton("年卡");
        yearCardButton.setBounds(150, 150, 60, 25);
        frame.add(yearCardButton);

        JRadioButton timesCardButton = new JRadioButton("次卡");
        timesCardButton.setBounds(150, 180, 60, 25);
        frame.add(timesCardButton);

        JTextField dataTextTimes = new JTextField();
        dataTextTimes.setBounds(210, 180, 60, 25);
        frame.add(dataTextTimes);

        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(addMemberButton);
        buttonGroup1.add(addCardButton);

        ButtonGroup buttonGroup2 = new ButtonGroup();
        buttonGroup2.add(yearCardButton);
        buttonGroup2.add(timesCardButton);

        JButton buttonSubmit = new JButton("提交");
        buttonSubmit.setBounds(170, 240, 80, 50);
        frame.add(buttonSubmit);

        frame.setVisible(true);

        addMemberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(addMemberButton.isSelected()) {
                    userOption = "添加会员";
                }
            }
        });

        addCardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(addCardButton.isSelected()) {
                    userOption = "办卡";
                    yearCardButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if(yearCardButton.isSelected())
                                cardOption = "年卡";
                        }
                    });
                    timesCardButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if(timesCardButton.isSelected())
                                cardOption = "次卡";
                        }
                    });
                }
            }
        });

        buttonSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if("添加会员".equals(userOption)) {
                    name = addMemberNameText.getText().trim();
                    address = addMemberAddressText.getText().trim();
                    job = addMemberJobText.getText().trim();
                    Member member = new Member(name, address, job);
                    MemberServiceImpl memberService = new MemberServiceImpl();
                    try {
                        if(memberService.findDuplicateMember(name)) {
                            logger.debug("写入数据库失败,会员已存在");
                            System.out.println("该会员已经存在");
                        }
                        else {
                            memberService.writeToMember(member);
                        }
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }

                if("办卡".equals(userOption)) {
                    name = addCardNameText.getText().trim();
                    Calendar c = Calendar.getInstance();
                    SimpleDateFormat current = new SimpleDateFormat("yyyy-MM-dd");
                    startTime = current.format(c.getTime());
                    if("年卡".equals(cardOption)) {
                        c.add(Calendar.YEAR, 1);
                        endTime = current.format(c.getTime());
                        times = 0;
                        type = "年卡";
                    }
                    if("次卡".equals(cardOption)) {
                        c.add(Calendar.YEAR, 3);
                        endTime = current.format(c.getTime());
                        times = Integer.parseInt(dataTextTimes.getText().trim());
                        type = "次卡";
                    }

                    Card card = new Card(type, startTime, endTime, times);
                    CardServiceImpl cardService = new CardServiceImpl();
                    OpenServiceImpl openService = new OpenServiceImpl();
                    try {
                        if(cardService.findMemberName(name)) {
                            cardService.writeToCard(name, card);
                            openService.writeToOpen(name);
                        }
                        else {
                            logger.debug("写入数据库失败,会员不存在");
                            System.out.println("该会员不存在");
                        }
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
        logger.info("show end");
    }
}
