import java.util.*;

class Player extends Random {
   //instance variables
   private PlayerKind kind;
	private float money;
	private ArrayList<Float> moneyOverTime;
	Random random = new Random();
	private int red, green, blue;
	private ArrayList<Integer> numbers;

	//constructor
	public Player(PlayerKind pK, float startFunds) {
		kind = pK;
		money = startFunds;
		moneyOverTime = new ArrayList<Float>();
		moneyOverTime.add(startFunds);
		red = random.nextInt(100);
		green = random.nextInt(100);
		blue = random.nextInt(100);

		//overall blue tint to POORLY_PAID
		if (kind == PlayerKind.WELL_PAID) {
			red += 100;
		} else {
			blue += 100;
		}
		ArrayList<Integer> W= new ArrayList<>();
		for (int i = 0; i < 42; i++) {
			W.add(i + 1);
		}
		Collections.shuffle(W, this.random);
		ArrayList<Integer> N = new ArrayList<>(W.subList(0, 5));
		numbers = N;
	}

	public int getR() { return red; }

	public int getG() { return green; }

	public int getB() { return blue; }

	public float getMoney() { return money; }

	public PlayerKind getKind() { return kind; }

	public ArrayList<Float> getFunds() { return moneyOverTime; }

	public ArrayList<Integer> getNumbers(){
		return numbers;
	}

	public void setMoney(Float cash){
		this.money = this.money + cash;
	}

	public void updateMoneyEachYear() {
		moneyOverTime.add(money);
	}

	@Override
	public boolean isDeprecated() {
		return super.isDeprecated();
	}
}
