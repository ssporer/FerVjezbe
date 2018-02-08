package hr.fer.pjava.service.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created by Igor Farszky on 8.2.2018..
 */
public class Utils {

    public static byte[] getScaledInstance(byte[] image, int targetWidth, int targetHeight, Object hint,
                                            boolean higherQuality) throws IOException {

        ByteArrayInputStream bis = null;
        bis = new ByteArrayInputStream(image);
        BufferedImage bufferedImage = ImageIO.read(bis);

        int type = (bufferedImage.getTransparency() == Transparency.OPAQUE) ? BufferedImage.TYPE_INT_RGB
                : BufferedImage.TYPE_INT_ARGB;
        BufferedImage ret = (BufferedImage) bufferedImage;
        if (ret.getHeight() < targetHeight || ret.getWidth() < targetWidth) {
            higherQuality = false;
        }
        int w, h;
        if (higherQuality) {
            // Use multi-step technique: start with original size, then
            // scale down in multiple passes with drawImage()
            // until the target size is reached
            w = bufferedImage.getWidth();
            h = bufferedImage.getHeight();
        } else {
            // Use one-step technique: scale directly from original
            // size to target size with a single drawImage() call
            w = targetWidth;
            h = targetHeight;
        }

        do {
            if (higherQuality && w > targetWidth) {
                w /= 2;
                if (w < targetWidth) {
                    w = targetWidth;
                }
            }

            if (higherQuality && h > targetHeight) {
                h /= 2;
                if (h < targetHeight) {
                    h = targetHeight;
                }
            }

            BufferedImage tmp = new BufferedImage(w, h, type);
            Graphics2D g2 = tmp.createGraphics();
            g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, hint);
            g2.drawImage(ret, 0, 0, w, h, null);
            g2.dispose();

            ret = tmp;
        } while (w != targetWidth || h != targetHeight);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write( ret, "png", baos );
        baos.flush();
        byte[] resThumb = baos.toByteArray();
        baos.close();

        return resThumb;
    }

}
