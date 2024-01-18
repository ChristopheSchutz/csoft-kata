export class GradeSchool {

    private data: Map<number, string[]> = new Map<number, string[]>();

    roster() {
        return JSON.parse(JSON.stringify(Object.fromEntries(this.data)));
    }

    add(name: string, grade: number) {
        this.removeStudentFromGrade(name);
        const students = this.data.get(grade) || [];
        students.push(name);
        students.sort();
        this.data.set(grade, students);
    }

    grade(grade: number): string[] {
        return [...(this.data.get(grade) || [])];
    }

    removeStudentFromGrade(name: string) {
        this.data.forEach((students, grade) => {
            this.data.set(grade, students.filter(student => student !== name));
        });
    }
}