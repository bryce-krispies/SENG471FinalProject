class StoreManager extends Salesperson {
    private String department;

    public StoreManager(String name, int salesersonId, department) {
        super(String name, int salesersonId);
        this.department = department;
    }
}