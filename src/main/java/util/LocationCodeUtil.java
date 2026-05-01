package util;

public class LocationCodeUtil {

    public static String generateCode(String type, String column, int layer, int grid, String side) {
        String layerStr = String.format("%02d", layer);
        return type + "-" + column + layerStr + "-" + grid + side;
    }

    public static boolean isValidCode(String code) {
        return code.matches("^T\\d+-[A-Z]\\d{2}-\\d+[FB]$");
    }
}
