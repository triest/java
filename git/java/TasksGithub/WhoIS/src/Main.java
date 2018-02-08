import java.io.IOException;
import java.net.SocketException;


class Main {

    public static void main(String args[]) throws Exception {

    }

    public String getWhoisDomainInformation(String domainName) {
        StringBuilder info = new StringBuilder("");
        WhoisClient whois = new WhoisClient();
        try {
            whois.connect(WhoisClient.DEFAULT_HOST);
            String data = whois.query("=" + domainName);
            info.append(data);
            whois.disconnect();

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return info.toString();
    }
}