package delivery;

import static delivery.Size.BIG;

public class DeliveryService {

    public static int deliveryCalculate(int distance, Size size, boolean fragility, Workload workload) {
        if (fragility && distance > 30) {
            throw new OrderInvalidException("Хрупкие товары нельзя отправлять на расстояние 30+ киллометров");
        }
        int result = (int) ((distanceCalc(distance) + sizeCalc(size) + fragilityCalc(fragility)) * workloadCalc(workload));
        return Math.max(result, 400);
    }

    private static int distanceCalc(int distance) {
        if (distance <= 0) {
            throw new OrderInvalidException("Расстояние должно быть больше 0");
        }
        if (distance > 30) {
            return 300;
        } else if (distance > 10) {
            return 200;
        } else if (distance > 2) {
            return 100;
        } else {
            return 50;
        }
    }

    private static int sizeCalc(Size size) {
        return (size == BIG) ? 200 : 100;
    }

    private static int fragilityCalc(boolean fragility) {
        return fragility ? 300 : 0;
    }

    private static double workloadCalc(Workload workload) {
        return workload.getRatio();
    }
}