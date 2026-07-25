package libraryBookManager;

import javax.swing.*;
import java.util.ArrayList;
import java.awt.*;
import javax.swing.table.DefaultTableModel;

public class LibraryGUI {

    JFrame frame;
    Library library;


    JButton addButton;
    JButton removeButton;
    JButton issueButton;
    JButton returnButton;
    JButton searchButton;
    JButton viewButton;
    JButton exitButton;
    JButton memberButton;
    JButton viewIssueButton;

    // Dashboard card values

    JLabel totalBooksLabel;
    JLabel availableBooksLabel;
    JLabel unavailableBooksLabel;

    public LibraryGUI(){


        library = new Library();

        frame = new JFrame("Library Book Manager");

        frame.setSize(1200,750);

        frame.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        frame.setLocationRelativeTo(null);

        frame.setResizable(true);

        frame.setLayout(
                new BorderLayout()
        );




        // ================= HEADER =================


        JPanel header = new JPanel();


        header.setBackground(
                new Color(31,31,31)
        );


        header.setPreferredSize(
                new Dimension(1200,90)
        );


        header.setLayout(
                new BorderLayout()
        );



        JLabel title = new JLabel(
                " Library Book Manager"
        );


        title.setForeground(
                Color.WHITE
        );


        title.setFont(
                new Font("Arial",Font.BOLD,34)
        );


        title.setBorder(
                BorderFactory.createEmptyBorder(
                        0,35,0,0
                )
        );



        header.add(
                title,
                BorderLayout.CENTER
        );






        // ================= SIDEBAR =================


        JPanel sidebar = new JPanel();


        sidebar.setBackground(
                new Color(31,31,31)
        );


        sidebar.setPreferredSize(
                new Dimension(250,650)
        );


        sidebar.setLayout(
                new GridLayout(9,1,20,20)
        );


        sidebar.setBorder(
                BorderFactory.createEmptyBorder(
                        40,25,40,25
                )
        );



        addButton = createButton(" Add Book");

        removeButton = createButton(" Remove Book");

        issueButton = createButton(" Issue Book");

        returnButton = createButton(" Return Book");

        searchButton = createButton(" Search Book");

        viewButton = createButton(" View Books");
        memberButton = createButton(" Manage Members");
        viewIssueButton = createButton(" Issue History");

        exitButton = createButton(" Exit");



        sidebar.add(addButton);

        sidebar.add(removeButton);

        sidebar.add(issueButton);

        sidebar.add(returnButton);

        sidebar.add(searchButton);

        sidebar.add(viewButton);
        sidebar.add(memberButton);
        sidebar.add(viewIssueButton);

        sidebar.add(exitButton);




        // ================= ACTION LISTENERS =================


        addButton.addActionListener(e -> {

            addBookWindow();

        });
        issueButton.addActionListener(e -> {

            issueBookWindow();

        });
        returnButton.addActionListener(e -> {

            returnBookWindow();

        });
        removeButton.addActionListener(e -> {

            removeBookWindow();

        });
        searchButton.addActionListener(e -> {

            searchBookWindow();

        });
        viewButton.addActionListener(e -> {

            viewBooksWindow();

        });
        viewIssueButton.addActionListener(e -> {

            viewIssueHistoryWindow();

        });
        exitButton.addActionListener(e -> {

            int choice = JOptionPane.showConfirmDialog(
                    frame,
                    "Are you sure you want to exit?",
                    "Exit Library System",
                    JOptionPane.YES_NO_OPTION
            );


            if(choice == JOptionPane.YES_OPTION){

                System.exit(0);

            }

        });
        memberButton.addActionListener(e -> {

            memberWindow();

        });
        // ================= MAIN DASHBOARD =================


        JPanel mainPanel = new JPanel();


        mainPanel.setBackground(
                new Color(245,246,247)
        );


        mainPanel.setLayout(
                new BorderLayout()
        );

      JPanel welcomePanel = new JPanel();


        welcomePanel.setBackground(
                new Color(245,246,247)
        );


        welcomePanel.setLayout(
                new BorderLayout()
        );


        welcomePanel.setBorder(
                BorderFactory.createEmptyBorder(
                        40,0,0,0
                )
        );



        JLabel welcome = new JLabel(
                "Welcome to Library Dashboard",
                JLabel.CENTER
        );


        welcome.setFont(
                new Font("Arial",Font.BOLD,30)
        );


        welcome.setForeground(
                new Color(21,101,192)
        );

        JLabel subtitle = new JLabel(
                "Manage books easily and efficiently",
                JLabel.CENTER
        );


        subtitle.setFont(
                new Font("Arial",Font.PLAIN,18)
        );


        subtitle.setForeground(
                new Color(70,70,70)
        );



        JPanel textPanel = new JPanel(
                new GridLayout(2,1)
        );


        textPanel.setBackground(
                new Color(245,246,247)
        );


        textPanel.add(welcome);

        textPanel.add(subtitle);



        welcomePanel.add(
                textPanel,
                BorderLayout.CENTER
        );



        // ================= CARDS PANEL =================


        JPanel cardsPanel = new JPanel();


        cardsPanel.setBackground(
                new Color(245,246,247)
        );


        cardsPanel.setLayout(
                new FlowLayout(
                        FlowLayout.CENTER,
                        50,
                        100
                )
        );



        // Dashboard values


        totalBooksLabel = new JLabel("0");


        availableBooksLabel = new JLabel("0");


        unavailableBooksLabel = new JLabel("0");




        cardsPanel.add(
                createCard(
                        "Total Books",
                        "",
                        totalBooksLabel
                )
        );



        cardsPanel.add(
                createCard(
                        "Currently Available",
                        "",
                        availableBooksLabel
                )
        );



        cardsPanel.add(
                createCard(
                        "Currently Not Available",
                        "",
                        unavailableBooksLabel
                )
        );




        mainPanel.add(
                welcomePanel,
                BorderLayout.NORTH
        );


        mainPanel.add(
                cardsPanel,
                BorderLayout.CENTER
        );



        // ================= FOOTER =================


        JLabel footer = new JLabel(
                "Library Management System",
                JLabel.CENTER
        );


        footer.setFont(
                new Font("Arial",Font.PLAIN,15)
        );


        footer.setForeground(
                new Color(70,70,70)
        );


        frame.add(
                header,
                BorderLayout.NORTH
        );


        frame.add(
                sidebar,
                BorderLayout.WEST
        );


        frame.add(
                mainPanel,
                BorderLayout.CENTER
        );


        frame.add(
                footer,
                BorderLayout.SOUTH
        );



        frame.setVisible(true);



        updateDashboard();


    }
    // ================= BUTTON CREATION =================


    private JButton createButton(String text){


        JButton button = new JButton(text);



        button.setFont(
                new Font("Arial",Font.BOLD,16)
        );



        button.setBackground(
                new Color(25,118,210)
        );



        button.setForeground(
                Color.WHITE
        );



        button.setFocusPainted(false);



        return button;

    }


    // ================= CARD CREATION =================


    private JPanel createCard(String title, String icon, JLabel numberLabel){


        JPanel card = new JPanel();


        card.setPreferredSize(
                new Dimension(280,180)
        );


        card.setBackground(
                Color.WHITE
        );


        card.setLayout(
                new BorderLayout()
        );



        JLabel iconLabel = new JLabel(
                icon,
                JLabel.CENTER
        );


        iconLabel.setFont(
                new Font("Arial",Font.PLAIN,35)
        );




        JLabel titleLabel = new JLabel(
                title,
                JLabel.CENTER
        );


        titleLabel.setFont(
                new Font("Arial",Font.BOLD,20)
        );


        titleLabel.setForeground(
                new Color(21,101,192)
        );

        numberLabel.setFont(
                new Font("Arial",Font.BOLD,42)
        );


        numberLabel.setForeground(
                new Color(31,31,31)
        );


        numberLabel.setHorizontalAlignment(
                JLabel.CENTER
        );





        JPanel topPanel = new JPanel(
                new GridLayout(2,1)
        );


        topPanel.setBackground(
                Color.WHITE
        );


        topPanel.add(iconLabel);


        topPanel.add(titleLabel);




        card.add(
                topPanel,
                BorderLayout.NORTH
        );


        card.add(
                numberLabel,
                BorderLayout.CENTER
        );



        card.setBorder(
                BorderFactory.createCompoundBorder(

                        BorderFactory.createLineBorder(
                                new Color(220,220,220),
                                1
                        ),

                        BorderFactory.createEmptyBorder(
                                15,15,15,15
                        )
                )
        );



        return card;

    }
    

    // ================= UPDATE DASHBOARD =================


    private void updateDashboard(){



        totalBooksLabel.setText(
                String.valueOf(
                        library.getTotalBooks()
                )
        );



        availableBooksLabel.setText(
                String.valueOf(
                        library.getAvailableBooks()
                )
        );



        unavailableBooksLabel.setText(
                String.valueOf(
                        library.getUnavailableBooks()
                )
        );


    }


    // ================= ADD BOOK WINDOW =================


    private void addBookWindow(){


        JFrame addFrame = new JFrame("Add Book");


        addFrame.setSize(450,400);


        addFrame.setLocationRelativeTo(frame);


        addFrame.setLayout(new BorderLayout());



        JPanel panel = new JPanel();


        panel.setLayout(
                new GridLayout(7,2,10,10)
        );



        panel.setBorder(
                BorderFactory.createEmptyBorder(
                        20,20,20,20
                )
        );



        JLabel titleLabel = new JLabel("Book Title:");

        JLabel authorLabel = new JLabel("Author:");

        JLabel isbnLabel = new JLabel("ISBN:");

        JLabel quantityLabel = new JLabel("Quantity:");



        JTextField titleField = new JTextField();

        JTextField authorField = new JTextField();

        JTextField isbnField = new JTextField();

        JTextField quantityField = new JTextField();
        JComboBox<String> categoryBox;

        JComboBox<String> genreBox;



        JButton saveButton = new JButton("Add Book");
        saveButton.setBackground(new Color(25,118,210));
        saveButton.setForeground(Color.WHITE);
        saveButton.setFocusPainted(false);
        saveButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
        String categories[] = {

                "Computer Science",
                "Engineering",
                "Science",
                "Literature",
                "History",
                "Mathematics"

        };
        String genres[] = {

                "Programming",
                "Database",
                "Research",
                "Novel",
                "Fantasy",
                "Biography"

        };


        genreBox = new JComboBox<>(genres);


        categoryBox = new JComboBox<>(categories);
       

        panel.add(titleLabel);
        panel.add(titleField);


        panel.add(authorLabel);
        panel.add(authorField);


        panel.add(isbnLabel);
        panel.add(isbnField);


        panel.add(quantityLabel);
        panel.add(quantityField);
        panel.add(new JLabel("Category"));
        panel.add(categoryBox);


        panel.add(new JLabel("Genre"));
        panel.add(genreBox);
        


        panel.add(new JLabel(""));
        panel.add(saveButton);




        addFrame.add(
                panel,
                BorderLayout.CENTER
        );



        addFrame.setVisible(true);


        saveButton.addActionListener(e -> {


            try{


                String title = titleField.getText();

                String author = authorField.getText();

                String isbn = isbnField.getText();



                int quantity = Integer.parseInt(
                        quantityField.getText()
                );


                if(quantity <= 0){

                    JOptionPane.showMessageDialog(
                            addFrame,
                            "Quantity must be greater than 0!"
                    );

                    return;

                }


                String category =
                        categoryBox.getSelectedItem().toString();


                String genre =
                        genreBox.getSelectedItem().toString();



                Book book = new Book(
                        title,
                        author,
                        isbn,
                        quantity,
                        category,
                        genre
                );


                boolean added = library.addBook(book);


                if(added){


                    updateDashboard();


                    JOptionPane.showMessageDialog(
                            addFrame,
                            "Book Added Successfully!"
                    );


                    addFrame.dispose();


                }
                else{


                    JOptionPane.showMessageDialog(
                            addFrame,
                            "Book with same ISBN but different title already exists!"
                    );


                }

                addFrame.dispose();



            }
            catch(Exception ex){


                JOptionPane.showMessageDialog(
                        addFrame,
                        "Please enter valid data!"
                );


            }


        });


    }

    private void issueBookWindow(){


        JFrame issueFrame = new JFrame("Issue Book");


        issueFrame.setSize(400,250);


        issueFrame.setLocationRelativeTo(frame);


        issueFrame.setLayout(new BorderLayout());



        JPanel panel = new JPanel();


        panel.setLayout(
                new GridLayout(3,2,10,10)
        );


        panel.setBorder(
                BorderFactory.createEmptyBorder(
                        20,20,20,20
                )
        );



        JLabel isbnLabel = new JLabel("Enter ISBN:");



        JTextField isbnField = new JTextField();
        JLabel memberLabel = new JLabel("Enter Member ID:");

        JTextField memberField = new JTextField();



        JButton issueButton = new JButton("Issue Book");
        issueButton.setBackground(
                new Color(25,118,210)
        );

        issueButton.setForeground(
                Color.WHITE
        );

        issueButton.setFont(
                new Font("Arial", Font.BOLD, 14)
        );

        issueButton.setFocusPainted(false);



        panel.add(isbnLabel);

        panel.add(isbnField);


        panel.add(memberLabel);

        panel.add(memberField);


        panel.add(new JLabel(""));

        panel.add(issueButton);



        issueFrame.add(
                panel,
                BorderLayout.CENTER
        );



        issueFrame.setVisible(true);



        issueButton.addActionListener(e -> {


            String isbn = isbnField.getText().trim();

            String memberId = memberField.getText().trim();



            if(isbn.isEmpty() || memberId.isEmpty()){


                JOptionPane.showMessageDialog(
                        issueFrame,
                        "Please enter ISBN and Member ID!"
                );


                return;

            }



            // Check book exists

            Book book = library.searchBookByISBN(isbn);



            if(book == null){


                JOptionPane.showMessageDialog(
                        issueFrame,
                        "Book with this ISBN not found!"
                );


                return;

            }




            // Check member exists

            Member member = library.searchMember(memberId);



            if(member == null){


                JOptionPane.showMessageDialog(
                        issueFrame,
                        "Member with this ID not found!"
                );


                return;

            }


            // Check quantity

            if(book.getQuantity() == 0){


                JOptionPane.showMessageDialog(
                        issueFrame,
                        "Book is currently not available!"
                );


                return;

            }


            // Decrease quantity

            boolean issued =
                    library.issueBook(isbn, memberId);



            if(issued){

            updateDashboard();



                JOptionPane.showMessageDialog(
                        issueFrame,
                        "Book issued successfully to "
                        + member.getName()
                );



                issueFrame.dispose();


            }


        });
    }
    private void memberWindow(){


        JFrame memberFrame = new JFrame("Member Management");


        memberFrame.setSize(500,350);


        memberFrame.setLocationRelativeTo(frame);


        memberFrame.setLayout(new BorderLayout());



        JPanel buttonPanel = new JPanel();


        buttonPanel.setLayout(
                new GridLayout(4,1,20,20)
        );


        buttonPanel.setBorder(
                BorderFactory.createEmptyBorder(
                        40,80,40,80
                )
        );



        JButton addMemberButton =
                new JButton("Add Member");


        JButton removeMemberButton =
                new JButton("Remove Member");


        JButton viewMemberButton =
                new JButton("View Members");
        JButton searchMemberButton =
                new JButton("Search Member");
     // Blue button style for Member Management buttons

        addMemberButton.setBackground(
                new Color(25,118,210)
        );

        addMemberButton.setForeground(
                Color.WHITE
        );

        addMemberButton.setFont(
                new Font("Arial", Font.BOLD, 14)
        );

        addMemberButton.setFocusPainted(false);



        removeMemberButton.setBackground(
                new Color(25,118,210)
        );

        removeMemberButton.setForeground(
                Color.WHITE
        );

        removeMemberButton.setFont(
                new Font("Arial", Font.BOLD, 14)
        );

        removeMemberButton.setFocusPainted(false);



        viewMemberButton.setBackground(
                new Color(25,118,210)
        );

        viewMemberButton.setForeground(
                Color.WHITE
        );

        viewMemberButton.setFont(
                new Font("Arial", Font.BOLD, 14)
        );

        viewMemberButton.setFocusPainted(false);



        searchMemberButton.setBackground(
                new Color(25,118,210)
        );

        searchMemberButton.setForeground(
                Color.WHITE
        );

        searchMemberButton.setFont(
                new Font("Arial", Font.BOLD, 14)
        );

        searchMemberButton.setFocusPainted(false);



        buttonPanel.add(addMemberButton);

        buttonPanel.add(removeMemberButton);

        buttonPanel.add(viewMemberButton);
        buttonPanel.add(searchMemberButton);



        memberFrame.add(
                buttonPanel,
                BorderLayout.CENTER
        );



        memberFrame.setVisible(true);


        addMemberButton.addActionListener(e -> {

            addMemberWindow();

        });

    removeMemberButton.addActionListener(e -> {

            removeMemberWindow();

        });



        viewMemberButton.addActionListener(e -> {

            viewMemberWindow();

        });

        searchMemberButton.addActionListener(e -> {

            searchMemberWindow();

        });

    }
    private void addMemberWindow(){


        JFrame addMemberFrame = new JFrame("Add Member");


        addMemberFrame.setSize(450,350);


        addMemberFrame.setLocationRelativeTo(frame);


        addMemberFrame.setLayout(new BorderLayout());



        JPanel panel = new JPanel();


        panel.setLayout(
                new GridLayout(5,2,10,10)
        );


        panel.setBorder(
                BorderFactory.createEmptyBorder(
                        20,20,20,20
                )
        );



        JLabel idLabel = new JLabel("Member ID:");

        JLabel nameLabel = new JLabel("Name:");

        JLabel emailLabel = new JLabel("Email:");

        JLabel phoneLabel = new JLabel("Phone:");



        JTextField idField = new JTextField();

        JTextField nameField = new JTextField();

        JTextField emailField = new JTextField();

        JTextField phoneField = new JTextField();



        JButton saveButton = new JButton("Add Member");
      

        saveButton.setBackground(
                new Color(25,118,210)
        );


        saveButton.setForeground(
                Color.WHITE
        );


        saveButton.setFont(
                new Font("Arial", Font.BOLD, 14)
        );


        saveButton.setFocusPainted(false);


        saveButton.setOpaque(true);



        panel.add(idLabel);
        panel.add(idField);


        panel.add(nameLabel);
        panel.add(nameField);


        panel.add(emailLabel);
        panel.add(emailField);


        panel.add(phoneLabel);
        panel.add(phoneField);


        panel.add(new JLabel(""));
        panel.add(saveButton);



        addMemberFrame.add(
                panel,
                BorderLayout.CENTER
        );


        addMemberFrame.setVisible(true);

        saveButton.addActionListener(e -> {


            String id = idField.getText().trim();

            String name = nameField.getText().trim();

            String email = emailField.getText().trim();

            String phone = phoneField.getText().trim();



            if(id.isEmpty() || name.isEmpty()){


                JOptionPane.showMessageDialog(
                        addMemberFrame,
                        "Member ID and Name are required!"
                );


                return;

            }




            Member member = new Member(
                    id,
                    name,
                    email,
                    phone
            );


            boolean added = library.addMember(member);

            if(added){


                JOptionPane.showMessageDialog(
                        addMemberFrame,
                        "Member added successfully!"
                );


                addMemberFrame.dispose();


            }
            else{


                JOptionPane.showMessageDialog(
                        addMemberFrame,
                        "Member with this ID already exists!"
                );


            }



        });



    }
    private void removeMemberWindow(){


        JFrame removeMemberFrame = new JFrame("Remove Member");


        removeMemberFrame.setSize(450,260);


        removeMemberFrame.setLocationRelativeTo(frame);


        removeMemberFrame.setLayout(new BorderLayout());



        JPanel mainPanel = new JPanel();


        mainPanel.setLayout(
                new BoxLayout(mainPanel, BoxLayout.Y_AXIS)
        );


        mainPanel.setBorder(
                BorderFactory.createEmptyBorder(
                        20,30,20,30
                )
        );



        // Heading

        JLabel heading = new JLabel(
                "Remove Member",
                JLabel.CENTER
        );


        heading.setAlignmentX(Component.CENTER_ALIGNMENT);


        heading.setFont(
                new Font("Arial",Font.BOLD,22)
        );


        heading.setForeground(
                new Color(21,101,192)
        );



        mainPanel.add(heading);



        mainPanel.add(
                Box.createVerticalStrut(15)
        );



        // Input Panel

        JPanel inputPanel = new JPanel();


        inputPanel.setLayout(
                new FlowLayout(
                        FlowLayout.CENTER,
                        10,
                        5
                )
        );



        JLabel idLabel =
                new JLabel("Member ID:");



        JTextField idField =
                new JTextField();



        idField.setPreferredSize(
                new Dimension(180,30)
        );



        inputPanel.add(idLabel);

        inputPanel.add(idField);



        mainPanel.add(inputPanel);



        mainPanel.add(
                Box.createVerticalStrut(15)
        );



        // Button

        JButton removeButton =
                new JButton("Remove Member");



        removeButton.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );


        removeButton.setPreferredSize(
                new Dimension(150,35)
        );


        removeButton.setMaximumSize(
                new Dimension(150,35)
        );


        removeButton.setBackground(
                new Color(25,118,210)
        );


        removeButton.setForeground(
                Color.WHITE
        );


        removeButton.setFocusPainted(false);



        mainPanel.add(removeButton);



        removeMemberFrame.add(
                mainPanel,
                BorderLayout.CENTER
        );



        removeMemberFrame.setVisible(true);
        removeButton.addActionListener(e -> {


            String memberId = idField.getText().trim();



            if(memberId.isEmpty()){


                JOptionPane.showMessageDialog(
                        removeMemberFrame,
                        "Please enter Member ID!"
                );


                return;

            }

            // First check member exists

            Member member =
                    library.searchMember(memberId);



            if(member == null){


                JOptionPane.showMessageDialog(
                        removeMemberFrame,
                        "Member with this ID not found!"
                );


                return;

            }


     // Confirmation

            int choice =
                    JOptionPane.showConfirmDialog(
                            removeMemberFrame,
                            "Are you sure you want to remove "
                            + member.getName() + "?",
                            "Confirm Removal",
                            JOptionPane.YES_NO_OPTION
                    );



            if(choice == JOptionPane.YES_OPTION){



                boolean removed =
                        library.removeMember(memberId);



                if(removed){


                    JOptionPane.showMessageDialog(
                            removeMemberFrame,
                            "Member removed successfully!"
                    );


                    removeMemberFrame.dispose();


                }


            }


        });


    }
    private void viewMemberWindow(){


        JFrame viewMemberFrame = new JFrame("All Members");


        viewMemberFrame.setSize(700,400);


        viewMemberFrame.setLocationRelativeTo(frame);


        viewMemberFrame.setLayout(new BorderLayout());



        String columns[] = {

                "Member ID",
                "Name",
                "Email",
                "Phone"

        };



        javax.swing.table.DefaultTableModel model =
                new javax.swing.table.DefaultTableModel(columns,0);



        JTable table = new JTable(model);



        table.setRowHeight(30);



        table.getTableHeader().setFont(
                new Font("Arial",Font.BOLD,14)
        );




        ArrayList<Member> members =
                library.viewAllMembers();




        for(Member member : members){



            Object row[] = {


                    member.getMemberId(),

                    member.getName(),

                    member.getEmail(),

                    member.getPhone()


            };



            model.addRow(row);



        }




        JScrollPane scrollPane =
                new JScrollPane(table);



        viewMemberFrame.add(
                scrollPane,
                BorderLayout.CENTER
        );



        viewMemberFrame.setVisible(true);



    }
    private void returnBookWindow(){


        JFrame returnFrame = new JFrame("Return Book");


        returnFrame.setSize(400,250);


        returnFrame.setLocationRelativeTo(frame);


        returnFrame.setLayout(new BorderLayout());



        JPanel panel = new JPanel();


        panel.setLayout(
                new GridLayout(3,2,10,10)
        );


        panel.setBorder(
                BorderFactory.createEmptyBorder(
                        20,20,20,20
                )
        );



        JLabel isbnLabel = new JLabel("Enter ISBN:");



        JTextField isbnField = new JTextField();
        JLabel memberLabel = new JLabel("Enter Member ID:");

        JTextField memberField = new JTextField();



        JButton returnButton = new JButton("Return Book");
        returnButton.setBackground(
                new Color(25,118,210)
        );

        returnButton.setForeground(
                Color.WHITE
        );

        returnButton.setFont(
                new Font("Arial", Font.BOLD, 14)
        );

        returnButton.setFocusPainted(false);



        panel.add(isbnLabel);

        panel.add(isbnField);
        panel.add(memberLabel);

        panel.add(memberField);



        panel.add(new JLabel(""));

        panel.add(returnButton);



        returnFrame.add(
                panel,
                BorderLayout.CENTER
        );



        returnFrame.setVisible(true);






        returnButton.addActionListener(e -> {


            String isbn = isbnField.getText().trim();

            String memberId = memberField.getText().trim();



            if(isbn.isEmpty() || memberId.isEmpty()){


                JOptionPane.showMessageDialog(
                        returnFrame,
                        "Please enter ISBN and Member ID!"
                );


                return;

            }



            // Check book exists

            Book book = library.searchBookByISBN(isbn);



            if(book == null){


                JOptionPane.showMessageDialog(
                        returnFrame,
                        "Book with this ISBN not found!"
                );


                return;

            }





            // Check member exists

            Member member = library.searchMember(memberId);



            if(member == null){


                JOptionPane.showMessageDialog(
                        returnFrame,
                        "Member with this ID not found!"
                );


                return;

            }





            // Find issue record

            IssueRecord foundRecord = null;



            for(IssueRecord record : library.viewAllIssueRecords()){


                if(record.getISBN().equals(isbn)
                        &&
                   record.getMemberId().equals(memberId)
                        &&
                   !record.isReturned()){


                    foundRecord = record;

                    break;

                }

            }




            if(foundRecord == null){


                JOptionPane.showMessageDialog(
                        returnFrame,
                        "This member has not issued this book!"
                );


                return;

            }





           

            int fine = library.returnBook(isbn,memberId);


            if(fine == -1){


                JOptionPane.showMessageDialog(
                        returnFrame,
                        "Book return failed!"
                );


                return;

            }


            updateDashboard();



            JOptionPane.showMessageDialog(
                    returnFrame,
                    "Book returned successfully by "
                    + member.getName()
                    + "\n\nFine: Rs. "
                    + fine
            );



            returnFrame.dispose();



        });



    }



  
    private void removeBookWindow() {

        JFrame removeFrame = new JFrame("Remove Book");

        removeFrame.setSize(450,300);

        removeFrame.setLocationRelativeTo(frame);

        removeFrame.setLayout(new BorderLayout());



        // ================= HEADING =================

        JLabel heading = new JLabel(
                "Remove Book",
                JLabel.CENTER
        );

        heading.setFont(
                new Font("Arial", Font.BOLD, 26)
        );

        heading.setForeground(
                new Color(21,101,192)
        );

        heading.setBorder(
                BorderFactory.createEmptyBorder(20,0,10,0)
        );



        removeFrame.add(
                heading,
                BorderLayout.NORTH
        );



        // ================= CENTER PANEL =================

        JPanel panel = new JPanel();

        panel.setLayout(
                new FlowLayout(
                        FlowLayout.CENTER,
                        15,
                        35
                )
        );



        JLabel isbnLabel =
                new JLabel("Enter ISBN:");

        isbnLabel.setFont(
                new Font("Arial",Font.PLAIN,16)
        );



        JTextField isbnField =
                new JTextField();

        isbnField.setPreferredSize(
                new Dimension(180,35)
        );



        JButton removeBtn =
                new JButton("Remove Book");


        removeBtn.setPreferredSize(
                new Dimension(140,35)
        );


        removeBtn.setFont(
                new Font("Arial",Font.BOLD,14)
        );


        removeBtn.setBackground(
                new Color(25,118,210)
        );


        removeBtn.setForeground(
                Color.WHITE
        );


        removeBtn.setFocusPainted(false);



        panel.add(isbnLabel);

        panel.add(isbnField);

        panel.add(removeBtn);



        removeFrame.add(
                panel,
                BorderLayout.CENTER
        );



        removeFrame.setVisible(true);




        // ================= ACTION =================


        removeBtn.addActionListener(e -> {


            String isbn =
                    isbnField.getText().trim();



            if(isbn.isEmpty()) {


                JOptionPane.showMessageDialog(
                        removeFrame,
                        "Please enter an ISBN."
                );

                return;

            }




            Book book =
                    library.searchBookByISBN(isbn);



            if(book == null) {


                JOptionPane.showMessageDialog(
                        removeFrame,
                        "Book with this ISBN not found!"
                );

                return;

            }




            int option =
                    JOptionPane.showConfirmDialog(
                            removeFrame,
                            "Are you sure you want to remove \""
                            + book.getTitle() + "\"?",
                            "Confirm Remove Book",
                            JOptionPane.YES_NO_OPTION
                    );




            if(option == JOptionPane.YES_OPTION) {


                boolean removed =
                        library.removeBook(isbn);



                if(removed) {


                    updateDashboard();


                    JOptionPane.showMessageDialog(
                            removeFrame,
                            "Book removed successfully!"
                    );


                    removeFrame.dispose();


                }
                else {


                    JOptionPane.showMessageDialog(
                            removeFrame,
                            "Cannot remove this book because it is currently issued!"
                    );


                }


            }


        });


    }
    private void searchBookWindow() {


        JFrame searchFrame = new JFrame("Search Book");


        searchFrame.setSize(550,450);


        searchFrame.setLocationRelativeTo(frame);


        searchFrame.setLayout(new BorderLayout());



        // Heading

        JLabel heading = new JLabel(
                "Search Book",
                JLabel.CENTER
        );


        heading.setFont(
                new Font("Arial", Font.BOLD, 24)
        );


        heading.setForeground(
                new Color(25,118,210)
        );


        heading.setBorder(
                BorderFactory.createEmptyBorder(
                        15,0,10,0
                )
        );


        searchFrame.add(
                heading,
                BorderLayout.NORTH
        );



        // Search panel

        JPanel topPanel = new JPanel();


        topPanel.setLayout(
                new FlowLayout(
                        FlowLayout.CENTER,
                        10,
                        10
                )
        );



        JLabel searchByLabel =
                new JLabel("Search By:");



        String options[] = {

                "ISBN",
                "Title",
                "Category",
                "Genre"

        };


        JComboBox<String> searchCombo =
                new JComboBox<>(options);


        searchCombo.setPreferredSize(
                new Dimension(120,28)
        );



        JLabel valueLabel =
                new JLabel("Value:");



        JTextField valueField =
                new JTextField();


        valueField.setPreferredSize(
                new Dimension(150,28)
        );



        JButton searchBtn =
                new JButton("Search");


        searchBtn.setPreferredSize(
                new Dimension(90,30)
        );


        searchBtn.setBackground(
                new Color(25,118,210)
        );


        searchBtn.setForeground(Color.WHITE);


        searchBtn.setFocusPainted(false);

        JButton updateBookButton =
                new JButton("Update Book");


        updateBookButton.setPreferredSize(
                new Dimension(110,30)
        );


        updateBookButton.setBackground(
                new Color(25,118,210)
        );


        updateBookButton.setForeground(Color.WHITE);


        updateBookButton.setFocusPainted(false);



        updateBookButton.setVisible(false);



        Book[] searchedBook = new Book[1];

        topPanel.add(searchByLabel);

        topPanel.add(searchCombo);


        topPanel.add(valueLabel);

        topPanel.add(valueField);


        topPanel.add(searchBtn);

        topPanel.add(updateBookButton);
       
        searchFrame.add(
                topPanel,
                BorderLayout.CENTER
        );


        // Result Area

        JTextArea resultArea =
                new JTextArea();


        resultArea.setEditable(false);


        resultArea.setFont(
                new Font(
                        "Monospaced",
                        Font.PLAIN,
                        13
                )
        );


        resultArea.setMargin(
                new Insets(8,8,8,8)
        );



        JScrollPane scrollPane =
                new JScrollPane(resultArea);



        scrollPane.setPreferredSize(
                new Dimension(450,220)
        );



        JPanel resultPanel =
                new JPanel();


        resultPanel.add(scrollPane);



        searchFrame.add(
                resultPanel,
                BorderLayout.SOUTH
        );



        searchFrame.setVisible(true);
       
        searchBtn.addActionListener(e -> {



            String searchType =
                    searchCombo.getSelectedItem().toString();



            String value =
                    valueField.getText().trim();



            if(value.isEmpty()){


                JOptionPane.showMessageDialog(
                        searchFrame,
                        "Please enter a value to search."
                );


                return;

            }



            resultArea.setText("");



            // ================= ISBN SEARCH =================


            if(searchType.equals("ISBN")){


                Book book =
                        library.searchBookByISBN(value);



                if(book != null){

                    searchedBook[0] = book;

                    displayBook(resultArea, book);

                    updateBookButton.setVisible(true);

                }
                else{


                    resultArea.setText(
                            "Book with this ISBN not found."
                    );


                }


            }



            // ================= TITLE SEARCH =================


            else if(searchType.equals("Title")){


                ArrayList<Book> books =
                        library.searchBookByTitle(value);



                if(books.isEmpty()){


                    resultArea.setText(
                            "No book found with this title."
                    );


                }
                else{


                    for(Book book : books){


                        displayBook(
                                resultArea,
                                book
                        );


                        resultArea.append(
                                "--------------------------------\n"
                        );


                    }


                }


            }



            // ================= CATEGORY SEARCH =================


            else if(searchType.equals("Category")){


                ArrayList<Book> books =
                        library.searchBooksByCategory(value);



                if(books.isEmpty()){


                    resultArea.setText(
                            "No book found with this category."
                    );


                }
                else{


                    for(Book book : books){


                        displayBook(
                                resultArea,
                                book
                        );


                        resultArea.append(
                                "--------------------------------\n"
                        );


                    }


                }


            }



            // ================= GENRE SEARCH =================


            else if(searchType.equals("Genre")){


                ArrayList<Book> books =
                        library.searchBooksByGenre(value);



                if(books.isEmpty()){


                    resultArea.setText(
                            "No book found with this genre."
                    );


                }
                else{


                    for(Book book : books){


                        displayBook(
                                resultArea,
                                book
                        );


                        resultArea.append(
                                "--------------------------------\n"
                        );


                    }


                }


            }



        });
        updateBookButton.addActionListener(e -> {

            if(searchedBook[0] != null){

                updateBookWindow(searchedBook[0]);

            }

        });


    }
    private void displayBook(JTextArea area, Book book){


        String status;


        if(book.getQuantity() > 0){

            status = "Available";

        }
        else{

            status = "Not Available";

        }


        area.append("========== BOOK DETAILS ==========\n\n");

        area.append("Title      : " + book.getTitle() + "\n");

        area.append("Author     : " + book.getAuthor() + "\n");

        area.append("ISBN       : " + book.getISBN() + "\n");

        area.append("Quantity   : " + book.getQuantity() + "\n");

        area.append("Category   : " + book.getCategory() + "\n");

        area.append("Genre      : " + book.getGenre() + "\n");

        area.append("Status     : " + status + "\n\n");

    }
    private void updateBookWindow(Book book){

        JFrame updateFrame = new JFrame("Update Book");

        updateFrame.setSize(450,500);

        updateFrame.setLocationRelativeTo(frame);

        updateFrame.setLayout(new GridLayout(8,2,10,10));


        JTextField titleField =
                new JTextField(book.getTitle());


        JTextField authorField =
                new JTextField(book.getAuthor());


        JTextField isbnField =
                new JTextField(book.getISBN());

        // ISBN should not be changed
        isbnField.setEditable(false);


        JTextField quantityField =
                new JTextField(
                        String.valueOf(book.getQuantity())
                );



        String categories[] = {

                "Computer Science",
                "Engineering",
                "Science",
                "Literature",
                "History",
                "Mathematics"

        };


        String genres[] = {

                "Programming",
                "Database",
                "Research",
                "Novel",
                "Fantasy",
                "Biography"

        };


        JComboBox<String> categoryBox =
                new JComboBox<>(categories);


        JComboBox<String> genreBox =
                new JComboBox<>(genres);



        // Show existing values

        categoryBox.setSelectedItem(
                book.getCategory()
        );


        genreBox.setSelectedItem(
                book.getGenre()
        );



     
        JButton saveButton =
                new JButton("Update");


        saveButton.setBackground(
                new Color(25,118,210)
        );


        saveButton.setForeground(
                Color.WHITE
        );


        saveButton.setFont(
                new Font("Arial", Font.BOLD, 14)
        );


        saveButton.setFocusPainted(false);


        saveButton.setOpaque(true);



        updateFrame.add(new JLabel("Title"));
        updateFrame.add(titleField);


        updateFrame.add(new JLabel("Author"));
        updateFrame.add(authorField);


        updateFrame.add(new JLabel("ISBN"));
        updateFrame.add(isbnField);


        updateFrame.add(new JLabel("Quantity"));
        updateFrame.add(quantityField);


        updateFrame.add(new JLabel("Category"));
        updateFrame.add(categoryBox);


        updateFrame.add(new JLabel("Genre"));
        updateFrame.add(genreBox);


        updateFrame.add(new JLabel(""));
        updateFrame.add(saveButton);



        updateFrame.setVisible(true);



        saveButton.addActionListener(e -> {


            try{


                boolean updated =
                        library.updateBook(
                                isbnField.getText(),
                                titleField.getText(),
                                authorField.getText(),
                                Integer.parseInt(
                                        quantityField.getText()
                                ),
                                categoryBox.getSelectedItem().toString(),
                                genreBox.getSelectedItem().toString()
                        );



                if(updated){


                    updateDashboard();


                    JOptionPane.showMessageDialog(
                            updateFrame,
                            "Book Updated Successfully!"
                    );


                    updateFrame.dispose();


                }
                else{


                    JOptionPane.showMessageDialog(
                            updateFrame,
                            "Book Update Failed!"
                    );


                }


            }
            catch(Exception ex){


                JOptionPane.showMessageDialog(
                        updateFrame,
                        "Please enter valid quantity!"
                );


            }


        });


    }
    private void viewBooksWindow(){


        JFrame viewFrame = new JFrame("All Books");


        viewFrame.setSize(800,500);


        viewFrame.setLocationRelativeTo(frame);


        viewFrame.setLayout(new BorderLayout());

        String columns[] = {

                "Title",
                "Author",
                "ISBN",
                "Quantity",
                "Category",
                "Genre",
                "Status"

        };

        javax.swing.table.DefaultTableModel model =
                new javax.swing.table.DefaultTableModel(columns,0);



        JTable table = new JTable(model);



        table.setRowHeight(30);


        table.getTableHeader().setFont(
                new Font("Arial",Font.BOLD,14)
        );




        ArrayList<Book> books =
                library.viewAllBooks();



        for(Book book : books){


            String status;


            if(book.getQuantity() > 0){

                status = "Available";

            }
            else{

                status = "Not Available";

            }


            

            Object row[] = {

                    book.getTitle(),

                    book.getAuthor(),

                    book.getISBN(),

                    book.getQuantity(),

                    book.getCategory(),

                    book.getGenre(),

                    status

            };


            model.addRow(row);


        }





        JScrollPane scrollPane =
                new JScrollPane(table);



        viewFrame.add(
                scrollPane,
                BorderLayout.CENTER
        );



        viewFrame.setVisible(true);



    }
    private void searchMemberWindow(){


        JFrame searchFrame = new JFrame("Search Member");


        searchFrame.setSize(500,400);


        searchFrame.setLocationRelativeTo(frame);


        searchFrame.setLayout(new BorderLayout());



        JPanel mainPanel = new JPanel();


        mainPanel.setLayout(
                new BorderLayout(10,10)
        );


        mainPanel.setBorder(
                BorderFactory.createEmptyBorder(
                        20,25,20,25
                )
        );



        // Heading

        JLabel heading = new JLabel(
                "Search Member",
                JLabel.CENTER
        );


        heading.setFont(
                new Font("Arial",Font.BOLD,24)
        );


        heading.setForeground(
                new Color(21,101,192)
        );



        mainPanel.add(
                heading,
                BorderLayout.NORTH
        );



        // Search area

        JPanel searchPanel = new JPanel();


        searchPanel.setLayout(
                new FlowLayout(
                        FlowLayout.CENTER,
                        10,
                        10
                )
        );



        JLabel idLabel =
                new JLabel("Member ID:");



        JTextField idField =
                new JTextField();



        idField.setPreferredSize(
                new Dimension(180,30)
        );



        JButton searchButton =
                new JButton("Search");



        searchButton.setPreferredSize(
                new Dimension(100,35)
        );


        searchButton.setBackground(
                new Color(25,118,210)
        );


        searchButton.setForeground(
                Color.WHITE
        );


        searchButton.setFocusPainted(false);


        searchButton.setFont(
                new Font("Arial",Font.BOLD,14)
        );



        JButton updateMemberButton =
                new JButton("Update Member");



        updateMemberButton.setPreferredSize(
                new Dimension(140,35)
        );


        updateMemberButton.setBackground(
                new Color(25,118,210)
        );


        updateMemberButton.setForeground(
                Color.WHITE
        );


        updateMemberButton.setFocusPainted(false);


        updateMemberButton.setFont(
                new Font("Arial",Font.BOLD,14)
        );


        updateMemberButton.setVisible(false);



        Member[] searchedMember = new Member[1];



        searchPanel.add(idLabel);

        searchPanel.add(idField);

        searchPanel.add(searchButton);



        mainPanel.add(
                searchPanel,
                BorderLayout.CENTER
        );



        JTextArea resultArea =
                new JTextArea();



        resultArea.setEditable(false);


        resultArea.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        15
                )
        );


        resultArea.setMargin(
                new Insets(10,10,10,10)
        );



        JPanel resultPanel =
                new JPanel(new BorderLayout(10,10));



        resultPanel.add(
                new JScrollPane(resultArea),
                BorderLayout.CENTER
        );


        resultPanel.add(
                updateMemberButton,
                BorderLayout.SOUTH
        );



        searchFrame.add(
                mainPanel,
                BorderLayout.NORTH
        );


        searchFrame.add(
                resultPanel,
                BorderLayout.CENTER
        );



        searchFrame.setVisible(true);

        searchButton.addActionListener(e -> {


            String id =
                    idField.getText().trim();



            Member member =
                    library.searchMember(id);



            if(member == null){

                resultArea.setText(
                        "Member with this ID not found!"
                );

                updateMemberButton.setVisible(false);

            }
            else{

                searchedMember[0] = member;

                resultArea.setText(

                        "Member Details\n\n" +
                        "ID: " + member.getMemberId() +
                        "\nName: " + member.getName() +
                        "\nEmail: " + member.getEmail() +
                        "\nPhone: " + member.getPhone()

                );


                updateMemberButton.setVisible(true);

            }

        });

        updateMemberButton.addActionListener(e -> {

            if(searchedMember[0] != null){

                updateMemberWindow(searchedMember[0]);

            }

        });
    }
    private void updateMemberWindow(Member member){


        JFrame updateFrame =
                new JFrame("Update Member");


        updateFrame.setSize(500,450);


        updateFrame.setLocationRelativeTo(frame);


        updateFrame.setLayout(
                new BorderLayout()
        );



        JPanel mainPanel =
                new JPanel(
                        new BorderLayout(10,10)
                );


        mainPanel.setBorder(
                BorderFactory.createEmptyBorder(
                        25,35,25,35
                )
        );



        // Heading

        JLabel heading =
                new JLabel(
                        "Update Member Details",
                        JLabel.CENTER
                );


        heading.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        24
                )
        );


        heading.setForeground(
                new Color(25,118,210)
        );



        mainPanel.add(
                heading,
                BorderLayout.NORTH
        );



        JPanel formPanel =
                new JPanel(
                        new GridLayout(5,2,15,15)
                );



        JTextField idField =
                new JTextField(
                        member.getMemberId()
                );


        idField.setEditable(false);



        JTextField nameField =
                new JTextField(
                        member.getName()
                );



        JTextField emailField =
                new JTextField(
                        member.getEmail()
                );



        JTextField phoneField =
                new JTextField(
                        member.getPhone()
                );



        formPanel.add(
                new JLabel("Member ID")
        );

        formPanel.add(
                idField
        );



        formPanel.add(
                new JLabel("Name")
        );

        formPanel.add(
                nameField
        );



        formPanel.add(
                new JLabel("Email")
        );

        formPanel.add(
                emailField
        );



        formPanel.add(
                new JLabel("Phone")
        );

        formPanel.add(
                phoneField
        );



        JButton updateButton =
                new JButton("Update Member");



        updateButton.setPreferredSize(
                new Dimension(150,40)
        );


        updateButton.setBackground(
                new Color(25,118,210)
        );


        updateButton.setForeground(
                Color.WHITE
        );


        updateButton.setFocusPainted(false);


        updateButton.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );



        formPanel.add(
                new JLabel("")
        );


        formPanel.add(
                updateButton
        );



        mainPanel.add(
                formPanel,
                BorderLayout.CENTER
        );



        updateFrame.add(
                mainPanel,
                BorderLayout.CENTER
        );


        updateFrame.setVisible(true);


        updateButton.addActionListener(e -> {


            boolean updated =
                    library.updateMember(
                            idField.getText(),
                            nameField.getText(),
                            emailField.getText(),
                            phoneField.getText()
                    );



            if(updated){


                JOptionPane.showMessageDialog(
                        updateFrame,
                        "Member Updated Successfully!"
                );


                updateFrame.dispose();


            }
            else{


                JOptionPane.showMessageDialog(
                        updateFrame,
                        "Member Update Failed!"
                );


            }


        });


    }
    private void viewIssueHistoryWindow(){


        JFrame issueHistoryFrame =
                new JFrame("Issue History");


        issueHistoryFrame.setSize(900,500);


        issueHistoryFrame.setLocationRelativeTo(frame);



        String columns[] = {

                "Member ID",
                "Member Name",
                "ISBN",
                "Book Title",
                "Issue Date",
                "Return Date",
                "Status",
                "Fine"

        };

        Object data[][] =
                new Object[library.viewAllIssueRecords().size()][8];



        int row = 0;



        for(IssueRecord record :
                library.viewAllIssueRecords()){


            Member member =
                    library.searchMember(
                            record.getMemberId()
                    );



            Book book =
                    library.searchBookByISBN(
                            record.getISBN()
                    );



            data[row][0] =
                    record.getMemberId();


            data[row][1] =
                    member != null ?
                    member.getName() :
                    "Unknown";


            data[row][2] =
                    record.getISBN();


            data[row][3] =
                    book != null ?
                    book.getTitle() :
                    "Unknown";


            data[row][4] =
                    record.getIssueDate();


            data[row][5] =
                    (record.getReturnDate() == null ||
                     record.getReturnDate().isEmpty())
                    ? "-"
                    : record.getReturnDate();


            data[row][6] =
                    record.isReturned()
                    ? "Returned"
                    : "Issued";


           
        
        data[row][7] =
                record.isReturned()
                ? library.calculateFine(record)
                : 0;
        row++;
        }
        JTable table = new JTable(data, columns);

        JScrollPane scrollPane = new JScrollPane(table);

        JPanel bottomPanel = new JPanel();


        JButton memberHistoryButton =
                new JButton("Member Borrowing History");


        JButton bookHistoryButton =
                new JButton("Book Borrowing History");
       


        // Blue button style

        memberHistoryButton.setBackground(
                new Color(25,118,210)
        );

        memberHistoryButton.setForeground(
                Color.WHITE
        );

        memberHistoryButton.setFont(
                new Font("Arial", Font.BOLD, 14)
        );

        memberHistoryButton.setFocusPainted(false);


        bookHistoryButton.setBackground(
                new Color(25,118,210)
        );

        bookHistoryButton.setForeground(
                Color.WHITE
        );

        bookHistoryButton.setFont(
                new Font("Arial", Font.BOLD, 14)
        );

        bookHistoryButton.setFocusPainted(false);



        bottomPanel.add(memberHistoryButton);

        bottomPanel.add(bookHistoryButton);
        memberHistoryButton.addActionListener(e -> {

            memberBorrowingHistoryWindow();

        });


        bookHistoryButton.addActionListener(e -> {

            bookBorrowingHistoryWindow();

        });



        issueHistoryFrame.add(
                scrollPane,
                BorderLayout.CENTER
        );


        issueHistoryFrame.add(
                bottomPanel,
                BorderLayout.SOUTH
        );



        issueHistoryFrame.setVisible(true);

       


    }
    private void memberBorrowingHistoryWindow(){


        JFrame memberFrame =
                new JFrame("Member Borrowing History");


        memberFrame.setSize(700,400);

        memberFrame.setLocationRelativeTo(frame);


        memberFrame.setLayout(new BorderLayout());



        JPanel topPanel = new JPanel();


        JLabel idLabel =
                new JLabel("Enter Member ID:");



        JTextField idField =
                new JTextField(15);



      
        JButton searchButton =
                new JButton("Search");


        searchButton.setBackground(
                new Color(25,118,210)
        );


        searchButton.setForeground(
                Color.WHITE
        );


        searchButton.setFont(
                new Font("Arial", Font.BOLD, 14)
        );


        searchButton.setFocusPainted(false);



        topPanel.add(idLabel);

        topPanel.add(idField);

        topPanel.add(searchButton);



        memberFrame.add(
                topPanel,
                BorderLayout.NORTH
        );



        String columns[] = {

                "Member ID",
                "Member Name",
                "ISBN",
                "Book Title",
                "Issue Date",
                "Return Date",
                "Status",
                "Fine"

        };


        JTable table =
                new JTable(
                        new Object[0][5],
                        columns
                );



        JScrollPane scrollPane =
                new JScrollPane(table);



        memberFrame.add(
                scrollPane,
                BorderLayout.CENTER
        );
        searchButton.addActionListener(e -> {


            String memberId = idField.getText().trim();



            if(memberId.isEmpty()){


                JOptionPane.showMessageDialog(
                        memberFrame,
                        "Please enter Member ID!"
                );


                return;

            }


            Member member =
                    library.searchMember(memberId);



            if(member == null){


                JOptionPane.showMessageDialog(
                        memberFrame,
                        "Member with this ID not found!"
                );


                return;

            }



            ArrayList<IssueRecord> records =
                    library.getMemberIssueRecords(memberId);



            if(records.isEmpty()){


                JOptionPane.showMessageDialog(
                        memberFrame,
                        "No borrowing record found for this member!"
                );


                return;

            }

            DefaultTableModel model =
                    new DefaultTableModel();


            model.addColumn("Book Title");

            model.addColumn("ISBN");

            model.addColumn("Issue Date");

            model.addColumn("Return Date");

            model.addColumn("Status");
            model.addColumn("Fine");



            for(IssueRecord record : records){


                Book book =
                        library.searchBookByISBN(
                                record.getISBN()
                        );



                model.addRow(new Object[]{


                        book != null ?
                        book.getTitle() :
                        "Unknown",


                        record.getISBN(),


                        record.getIssueDate(),


                        (record.getReturnDate() == null ||
                        record.getReturnDate().isEmpty())
                       ? "-"
                       : record.getReturnDate(),


                        record.isReturned()
                        ? "Returned"
                        : "Issued"
                        	,
                        	record.isReturned()
                        	? library.calculateFine(record)
                        	: 0

                });


            }



            table.setModel(model);



        });


        memberFrame.setVisible(true);

    }



    private void bookBorrowingHistoryWindow(){


        JFrame bookFrame =
                new JFrame("Book Borrowing History");


        bookFrame.setSize(750,400);


        bookFrame.setLocationRelativeTo(frame);


        bookFrame.setLayout(new BorderLayout());



        JPanel topPanel = new JPanel();



        JLabel isbnLabel =
                new JLabel("Enter ISBN:");



        JTextField isbnField =
                new JTextField(15);



        JButton searchButton =
                new JButton("Search");


        searchButton.setBackground(
                new Color(25,118,210)
        );


        searchButton.setForeground(
                Color.WHITE
        );


        searchButton.setFont(
                new Font("Arial", Font.BOLD, 14)
        );


        searchButton.setFocusPainted(false);



        topPanel.add(isbnLabel);

        topPanel.add(isbnField);

        topPanel.add(searchButton);



        bookFrame.add(
                topPanel,
                BorderLayout.NORTH
        );



        String columns[] = {

                "Member ID",
                "Member Name",
                "ISBN",
                "Book Title",
                "Issue Date",
                "Return Date",
                "Status",
                "Fine"

        };


        JTable table =
                new JTable(
                        new Object[0][8],
                        columns
                );



        JScrollPane scrollPane =
                new JScrollPane(table);



        bookFrame.add(
                scrollPane,
                BorderLayout.CENTER
        );



        searchButton.addActionListener(e -> {


            String isbn = isbnField.getText().trim();



            if(isbn.isEmpty()){


                JOptionPane.showMessageDialog(
                        bookFrame,
                        "Please enter ISBN!"
                );


                return;

            }



            // Check book exists

            Book book =
                    library.searchBookByISBN(isbn);



            if(book == null){


                JOptionPane.showMessageDialog(
                        bookFrame,
                        "Book with this ISBN not found!"
                );


                return;

            }



            ArrayList<IssueRecord> records =
                    library.getBookIssueRecords(isbn);



            if(records.isEmpty()){


                JOptionPane.showMessageDialog(
                        bookFrame,
                        "No borrowing record found for this book!"
                );


                return;

            }



            DefaultTableModel model =
                    new DefaultTableModel();



            model.addColumn("Member ID");

            model.addColumn("Member Name");

            model.addColumn("Issue Date");

            model.addColumn("Return Date");

            model.addColumn("Status");
            model.addColumn("Fine");



            for(IssueRecord record : records){



                Member member =
                        library.searchMember(
                                record.getMemberId()
                        );



                model.addRow(new Object[]{


                        record.getMemberId(),


                        member != null ?
                        member.getName() :
                        "Unknown",


                        record.getIssueDate(),


                        (record.getReturnDate() == null ||
                        record.getReturnDate().isEmpty())
                       ? "-"
                       : record.getReturnDate(),

                        record.isReturned()
                        ? "Returned"
                        : "Issued"
                        	,
                        	record.isReturned()
                        	? library.calculateFine(record)
                        	: 0


                });


            }



            table.setModel(model);



        });


        bookFrame.setVisible(true);


    }
    // ================= MAIN METHOD =================


    public static void main(String[] args){


        SwingUtilities.invokeLater(() -> {

            new LibraryGUI();

        });


    }


}