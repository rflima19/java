package lima.com;

import java.util.concurrent.RecursiveTask;

public class SomaElementosArray extends RecursiveTask<Integer> {

	private int[] array;
	private int min;
	private int max;
	
	public SomaElementosArray(int[] array, int min, int max) {
		super();
		this.array = array;
		this.min = min;
		this.max = max;
	}

	@Override
	protected Integer compute() {
		int length = max - min + 1;
		if (length < 4) {
			int partialSum = 0;
			for (int i = this.min; i <= this.max; i++) {
				partialSum += this.array[i];
			}
			return partialSum;
		}
		int half = length / 2;
		SomaElementosArray leftTask = new SomaElementosArray(this.array, this.min, this.min + half);
		SomaElementosArray rightTask = new SomaElementosArray(this.array, this.min + half + 1, this.max);
		leftTask.fork();
		rightTask.fork();
		int sumLeftTask = leftTask.join();
		int sumRightTask = rightTask.compute();
		return sumLeftTask + sumRightTask;
	}
}
