public abstract class Split {
    private String id;
    private User user;
    private Double amount;

    public Split(User user) {
        this.user = user;
    }
}
