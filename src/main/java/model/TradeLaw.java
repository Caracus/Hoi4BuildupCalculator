package model;

import lombok.Data;

@Data
public class TradeLaw {
    private float factoryOutputBonus = 0.0f;
    private float dockyardOutputBonus = 0.0f;
    private float constructionSpeedBonus = 0.0f;

    public TradeLaw(TradeLaws tradeLaws){
        switch (tradeLaws){
            case FREE_TRADE:
                this.factoryOutputBonus = 0.15f;
                this.dockyardOutputBonus = 0.15f;
                this.constructionSpeedBonus = 0.15f;
                break;
            case EXPORT_FOCUS:
                this.factoryOutputBonus = 0.1f;
                this.dockyardOutputBonus = 0.1f;
                this.constructionSpeedBonus = 0.1f;
                break;
            case LIMITED_EXPORTS:
                this.factoryOutputBonus = 0.05f;
                this.dockyardOutputBonus = 0.05f;
                this.constructionSpeedBonus = 0.05f;
                break;
            case CLOSED_ECONOMY:
                this.factoryOutputBonus = 0.0f;
                this.dockyardOutputBonus = 0.0f;
                this.constructionSpeedBonus = 0.0f;
                break;
        }
    }
}
