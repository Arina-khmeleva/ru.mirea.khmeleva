package pr4;

public class MainSeason {
    public static void main(String[] args) {
        Season favorite = Season.SUMMER;
        System.out.println("Любимое время года: " + favorite);
        System.out.println("Средняя температура: " + favorite.getAverageTemperature());
        System.out.println("Описание: " + favorite.getDescription());

        Season.printFavoriteSeason(favorite);

        for (Season s : Season.values()) {
            System.out.println(s + " | t = " + s.getAverageTemperature() +
                    " | " + s.getDescription());
        }

        System.out.println("name(): " + favorite.name());
        System.out.println("ordinal(): " + favorite.ordinal());
        System.out.println("valueOf: " + Season.valueOf("WINTER"));
    }
}
