public class Solution {

	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		if (A > E) {
			int tmp;
			tmp = A;
			A = E;
			E = tmp;
			tmp = B;
			B = F;
			F = tmp;
			tmp = C;
			C = G;
			G = tmp;
			tmp = D;
			D = H;
			H = tmp;
		}
		int sumArea = (C - A) * (D - B) + (G - E) * (H - F);
		if (B >= H || F >= D || E >= C) {
			return sumArea;
		}
		if (F <= B) {
			if (G >= C && H <= D) {
				return sumArea-((C-E)*(H-B));
			}
			if (G >= C && H >= D) {
				return sumArea-((C-E)*(D-B));
			}
			if (G <= C && H <= D) {
				return sumArea-((G-E)*(H-B));
			}
			if (G <= C && H >= D) {
				return sumArea-((G-E)*(D-B));
			}
		}
		if (F >= B) {
			if (G >= C && H <= D) {
				return sumArea-((C-E)*(H-F));
			}
			if (G >= C && H >= D) {
				return sumArea-((C-E)*(D-F));
			}
			if (G <= C && H <= D) {
				return sumArea-((G-E)*(H-F));
			}
			if (G <= C && H >= D) {
				return sumArea-((G-E)*(D-F));
			}
		}
		return 0;
	}
}