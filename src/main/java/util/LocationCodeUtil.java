package util;

public final class LocationCodeUtil {
    private LocationCodeUtil() {
    }

    public static String generateCode(String area, int shelfNo, int layerNo, int positionNo) {
        String normalizedArea = area == null || area.isBlank() ? "A" : area.trim().toUpperCase();
        return String.format("%s-%02d-%02d-%02d", normalizedArea, shelfNo, layerNo, positionNo);
    }
}
