import java.util.Random;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class PasswordGenerator {

	private PasswordGenerator() {

	}

	public static void main(String[] args) {

		Random random = new Random();
		char password[] = new char[13];
		char temp = ' ';

		for (int i = 0; i < 4; i++) {
			password[i] = (char) (random.nextInt(26) + 65);
		}
		for (int i = 4; i < 8; i++) {
			password[i] = (char) (random.nextInt(26) + 97);
		}

		for (int i = 0, m = 0, n = 0; i < 8; i++) {
			m = random.nextInt(8);
			n = random.nextInt(8);
			temp = password[m];
			password[m] = password[n];
			password[n] = temp;
		}

		password[8] = (char) (random.nextInt(15) + 33);

		for (int i = 9; i < 13; i++) {
			password[i] = (char) (random.nextInt(10) + 48);
		}

		String PASSWORD = String.valueOf(password);

		final Runtime run = Runtime.getRuntime();
		Process p = null;

		try {
			p = run.exec(new String[] { "zsh", "-c", "echo " + PASSWORD + " | xclip -selection clipboard" });
			p = run.exec(new String[] { "zsh", "-c", "echo " + PASSWORD + " | xclip -selection clipboard" });

		} catch (Exception e) {

			Toolkit toolkit = Toolkit.getDefaultToolkit();
			Clipboard clipboard = toolkit.getSystemClipboard();
			StringSelection strSel = new StringSelection(PASSWORD);
			clipboard.setContents(strSel, null);

		}

	}

}
