package HomeWork.AttestationWork;

public class Laptop {
    private String maker;
    private String model;
    private String processor;
    private int RAM;
    private int externalMemory;
    private double screenDiagonal;
    private String operationSystem;
    private int countProductiveCores;
    private int price;
    private int quantityInStock;
    private int discount;
    private int installmentPayment;

    public Laptop(String maker, String model, String processor, int RAM, int externalMemory,
                  double screenDiagonal, String operationSystem, int countProductiveCores,
                  int price, int quantityInStock, int discount, int installmentPayment) {
        this.maker = maker;
        this.model = model;
        this.processor = processor;
        this.RAM = RAM;
        this.externalMemory = externalMemory;
        this.screenDiagonal = screenDiagonal;
        this.operationSystem = operationSystem;
        this.countProductiveCores = countProductiveCores;
        this.price = price;
        this.quantityInStock = quantityInStock;
        this.discount = discount;
        this.installmentPayment = installmentPayment;
    }

    public String getValues() {
        return "Производитель: " + maker + "\nМодель: " + model + "\nПроцессор: " + processor
                + "\nОбъем оперативной памяти: " + RAM + "\nОбъем внешней памяти: " + externalMemory
                + "\nДиагональ экрана: " + screenDiagonal + "\nОперационная система: " + operationSystem
                + "\nКоличество производительных ядер: " + countProductiveCores + "\nЦена: " + price
                + "\nКоличество в наличии: " + quantityInStock + "\nСкидка: " + discount
                + "\nРассрочка: " + installmentPayment;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public void setRAM(int RAM) {
        this.RAM = RAM;
    }

    public void setExternalMemory(int externalMemory) {
        this.externalMemory = externalMemory;
    }

    public void setScreenDiagonal(double screenDiagonal) {
        this.screenDiagonal = screenDiagonal;
    }

    public void setOperationSystem(String operationSystem) {
        this.operationSystem = operationSystem;
    }

    public void setCountProductiveCores(int countProductiveCores) {
        this.countProductiveCores = countProductiveCores;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public void setInstallmentPayment(int installmentPayment) {
        this.installmentPayment = installmentPayment;
    }

    public String getMaker() {
        return this.maker;
    }

    public String getModel() {
        return this.model;
    }

    public String getProcessor() {
        return this.processor;
    }

    public int getRAM() {
        return this.RAM;
    }

    public int getExternalMemory() {
        return this.externalMemory;
    }

    public double getScreenDiagonal() {
        return this.screenDiagonal;
    }

    public String getOperationSystem() {
        return this.operationSystem;
    }

    public int getCountProductiveCores() {
        return this.countProductiveCores;
    }

    public int getPrice() {
        return this.price;
    }

    public int getQuantityInStock() {
        return this.quantityInStock;
    }

    public int getDiscount() {
        return this.discount;
    }

    public int getInstallmentPaymentMonth() {
        return this.installmentPayment;
    }
}
