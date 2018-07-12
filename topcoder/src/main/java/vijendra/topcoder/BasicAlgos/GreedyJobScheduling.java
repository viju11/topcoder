package vijendra.topcoder.BasicAlgos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class GreedyJobScheduling {

	class Job {
		public char id;
		public int deadline;
		public int profit;
	}

	public static void main(String[] args) {
		ArrayList<Job> jobs = new ArrayList<Job>();
		GreedyJobScheduling g = new GreedyJobScheduling();

		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			String nextLine = sc.nextLine();
			if (nextLine.trim().isEmpty() || nextLine.length() <= 1)
				break;

			String[] split = nextLine.split(" ");
			Job j = g.new Job();
			j.id = split[0].charAt(0);
			j.deadline = Integer.valueOf(split[1]);
			j.profit = Integer.valueOf(split[2]);
			jobs.add(j);
		}
		sc.close();

		boolean slots[] = new boolean[jobs.size()];
		int result[] = new int[jobs.size()];
		Collections.sort(jobs, new Comparator<Job>() {
			public int compare(Job o1, Job o2) {
				return Integer.compare(o2.profit, o1.profit);
			}
		});

		for (int i = 0; i < jobs.size(); i++) {

			for (int j = jobs.get(i).deadline - 1; j >= 0; j--) {
				if (j < jobs.size() && !slots[j]) {
					slots[j] = true;
					result[j] = i;
					break;
				}
			}

		}

		for (int i = 0; i < jobs.size(); i++) {
			if (slots[i]) {
				System.out.print(jobs.get(result[i]).id + " ");
			}
		}

	}
}
/*
give the following input
 a 2 100 
 b 1 19 
c 2 27
d 1 25 
e 3 15
 * 
 */
