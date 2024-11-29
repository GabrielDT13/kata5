package software.ulpgc.view;

import software.ulpgc.model.User;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;

public class RandomUserDisplay extends JPanel implements UserDisplay{
    @Override
    public void display(User user) {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));

        jPanel.add(loadPhoto(user));
        jPanel.add(userValues(user));
        add(jPanel);
    }

    private JLabel loadPhoto(User user) {
        BufferedImage image = readPhotoFromBytes(user);

        ImageIcon icon = new ImageIcon(image);
        JLabel label = new JLabel(icon);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        return label;
    }
    
    private BufferedImage readPhotoFromBytes(User user) {
        byte[] photo = user.getPhoto();
        try(ByteArrayInputStream data = new ByteArrayInputStream(photo)){
            return ImageIO.read(data);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private JPanel userValues(User user) {
        JLabel name = CreateCenterLabel(user.getName());
        JLabel email = CreateCenterLabel(user.getEmail());
        JLabel gender = CreateCenterLabel(String.valueOf(user.getGender()));

        name.setFont(new Font("Arial", Font.BOLD, 20));

        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));
        jPanel.add(name);
        jPanel.add(email);
        jPanel.add(gender);

        return jPanel;
    }

    private JLabel CreateCenterLabel(String value) {
        JLabel jLabel = new JLabel(value);
        jLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        return jLabel;
    }


}
