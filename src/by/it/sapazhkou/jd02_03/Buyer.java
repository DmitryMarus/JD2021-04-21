package by.it.sapazhkou.jd02_03;

import java.util.HashMap;

public class Buyer extends Thread implements IBuyer, IUseBasket {

    int num;
    boolean pensioner = false;

    private final Market market;

    private boolean waitFlag;

    public void setWaitFlag(boolean waitFlag) {
        this.waitFlag = waitFlag;
    }

    Object getMonitor() {
        return this;
    }


    public Buyer(int num, Market market) {

        super("Buyer #" + num + " ");
        this.num =num;
        this.market = market;
        market.getDispatcher().addNewBuyer();
    }

    public Buyer(int num, Market market, boolean pensioner) {

        super("Buyer #" + num + " ");
        this.num = num;
        this.pensioner = pensioner;
        this.market = market;
        market.getDispatcher().addNewBuyer();
    }



    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        goToQueue();
        goOut();
        market.getDispatcher().completeBuyer();
//        System.out.println("In market " + Dispatcher.currentCountBuyer + " buyers");
//        System.out.println("Вошедших " + Dispatcher.getInsideCountBuyers());
//        System.out.println(("Вышедших "+ Dispatcher.getCompleteCountBuyers()));
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + "has entered to market");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + "started choosing ");
        int timeChoose = RandomHelper.randomValue(Configs.CHOOSE_MIN, Configs.CHOOSE_MAX);
        timeChoose = (this.pensioner) ? (int) (timeChoose * 1.5) : timeChoose;
        TimerHelper.sleep(timeChoose);
        System.out.println(this + "completed selection ");
        putGoodsToBasket();

    }

    @Override
    public void goOut() {
        System.out.println(this + "left the store");
    }

    @Override
    public void goToQueue() {
        synchronized (this) {
            market.getQueueBuyers().add(this);
            try {
                waitFlag = true;
                while (waitFlag) {
                    this.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void takeBasket() {
        System.out.println(this + "take a basket ");
        int timeChoose = RandomHelper.randomValue(Configs.CHOOSE_MIN, Configs.CHOOSE_MAX);
        timeChoose = (this.pensioner) ? (int) (timeChoose * 1.5) : timeChoose;
        TimerHelper.sleep(timeChoose);
    }

    @Override
    public void putGoodsToBasket() {
        int countGood = RandomHelper.randomValue(0, 3);
        Basket basket = new Basket(this.num);
        for (int i = 0; i <= countGood; i++) {
            int idGood = RandomHelper.randomValue(0, 3);
            HashMap good = new PriceOfGood().getGoods();
            GoodEnum goodValue = GoodEnum.values()[idGood];
            basket.addToBasket(goodValue);
            int timeChoose = RandomHelper.randomValue(Configs.CHOOSE_MIN, Configs.CHOOSE_MAX);
            timeChoose = (this.pensioner) ? (int) (timeChoose * 1.5) : timeChoose;
            TimerHelper.sleep(timeChoose);
        }
        basket.toConsoleBasket(pensioner);
    }
}