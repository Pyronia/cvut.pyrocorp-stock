package eu.pyrocorp.shared.market;

/**
 * Created by Michal Hubálek.
 */
public class MarketStateDTO
{
    private Boolean isHalted;

    public MarketStateDTO(boolean isHalted)
    {
        setHalted(isHalted);
    }

    public Boolean getHalted()
    {
        return isHalted;
    }

    private void setHalted(Boolean halted)
    {
        isHalted = halted;
    }
}
