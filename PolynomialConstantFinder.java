import java.io.*;
import java.math.BigInteger;
import org.json.JSONObject;

public class PolynomialConstantFinder {

    public static void main(String[] args) {
        try {
            String jsonData = new String(java.nio.file.Files.readAllBytes(java.nio.file.Paths.get("data.json")));

            JSONObject obj = new JSONObject(jsonData);
            JSONObject keys = obj.getJSONObject("keys");
            int n = keys.getInt("n");

            BigInteger a = BigInteger.ONE;
            BigInteger b = BigInteger.ONE;

            JSONObject rootObj = obj.getJSONObject("2");
            int base = Integer.parseInt(rootObj.getString("base"));
            String valueStr = rootObj.getString("value");

            BigInteger y = new BigInteger(valueStr, base);

            BigInteger yPowN = y.pow(n);
            BigInteger yPowN_1 = y.pow(n - 1);

            BigInteger c = a.negate().multiply(yPowN).subtract(b.multiply(yPowN_1));

            System.out.println("Decoded y = " + y);
            System.out.println("n = " + n);
            System.out.println("Computed constant c = " + c);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
