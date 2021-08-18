package projectplayground.domains.enums;

public final class EnumValue {


    public static String cleanlinessLevelValue(Cleanliness cleanliness)
    {
        if(cleanliness != null)
        {
            switch (cleanliness) {
                case clean:
                    return "Sauber";
                case slightlyPolluted:
                    return "Leicht verschmutzt";
                case polluted:
                    return "Verschmutzt";
                default:
                    return "Kein Sauberkeitsstatus vorhanden";
            }
        }
        return "Kein Sauberkeitsstatus vorhanden";
    }


    public static String statusValue(Status status)
    {
        if(status != null) {
            switch (status) {
                case open:
                    return "Offen";
                case wellVisited:
                    return "Gut besucht";
                case full:
                    return "Voll";
                case overfilled:
                    return "Überfüllt";
                default:
                    return "Kein Status vorhanden";
            }
        }
        return "Kein Status vorhanden";
    }

    public static String deviceStatusValue(DeviceStatus deviceStatus)
    {
        if (deviceStatus != null) {
            switch (deviceStatus) {
                case cleanAndWorking:
                    return "Sauber und unbeschädigt";
                case pollutedDevice:
                    return "Leicht verschmutzt";
                case brokenDevice:
                    return "Beschädigt";
                case riskOfInjury:
                    return "Verletzungsgefahr";
                case toBeChecked:
                    return "Zu überprüfen";
                default:
                    return "Kein Gerätestatus vorhanden";
            }
        }
        return "Kein Gerätestatus vorhanden";
    }
}
