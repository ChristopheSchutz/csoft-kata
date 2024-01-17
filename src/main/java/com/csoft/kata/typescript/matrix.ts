export class Matrix {
    private data: string[][];
    private nbOfRows: number = 0;
    private nbOfColumns: number = 0;

    constructor(input: string) {
        this.data = [];
        this.extractData(input);
    }

    get rows(): number[][] {
        let results: number[][] = [];
        for (let i = 0; i < this.nbOfColumns; i++) {
            results.push(this.data[i].map(x => parseInt(x)));
        }
        return results;
    }

    get columns(): number[][] {
        let results: number[][] = [];
        for (let i = 0; i < this.nbOfColumns; i++) {
            let column: number[] = [];
            for (let j = 0; j < this.nbOfRows; j++) {
                column.push(parseInt(this.data[j][i]));
            }
            results.push(column);
        }
        return results;
    }

    private extractData(rawInput: string): void {
        let rows = rawInput.split("\n");
        this.nbOfRows = rows.length;
        for (let i = 0; i < this.nbOfRows; i++) {
            let entries = rows[i].split(" ");
            this.nbOfColumns = entries.length;
            for (let j = 0; j < this.nbOfColumns; j++) {
                if (!this.data[i]) {
                    this.data[i] = [];
                }
                this.data[i][j] = entries[j];
            }
        }
    }
}