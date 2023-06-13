//console.log("Demo App");
import Marks from './Marks.js';
class Student{
 constructor(rollNo,firstName,lastName){
   this.rollno=rollNo;
   this.firstname=firstName;
   this.lastname=lastName;
   this.marks=[];
   this.totalMarks=0;
 }
 addMark(subjectName,marks){
   const newMark=new Marks(subjectName,marks);
   this.marks.push(newMark);
   this.totalMarks +=marks;
  }
  calculateTotalMarks(){
  this.marks.forEach((mark)=>{
   this.totalMarks += mark.marks});
  }
  getResultPercentages(){
    return this.totalMarks/this.marks.length;
  }
  static countStudentWithDistinction(students){
  const studentsWithDistinction=students.filter((student)=>student.totalMarks>=200);
  console.log(`students with distinction: ${studentsWithDistinction.length}`);
  }
  static findStudentByRollno(students,rollNo){
   const x=students.find((x) => x.rollno==rollNo);
   if(x){
     console.log(`Rollno: ${x.rollno} \tName: ${x.firstname} ${x.lastname} \tTotalmarks: ${x.totalMarks}`);
   }else{
    console.log(`student with roll no ${rollNo}, not found`);
   }
 }
}

const students=[new Student(1,'sravanth','kumar'),
                new Student(2,'yash','kumar'),
                new Student(3,'virat','kohli'),
]

students[0].addMark('Maths',70);
students[0].addMark('science',90);
students[0].addMark('social',80);

students[1].addMark('maths',100);
students[1].addMark('science',85);
students[1].addMark('social',90);

students[2].addMark('Maths',99);
students[2].addMark('science',96);
students[2].addMark('social',97);

students.forEach((student) => {
  student.calculateTotalMarks();
});

const resultPercentages = students.map((student) => student.getResultPercentages());
console.log(resultPercentages);

Student.countStudentWithDistinction(students);
Student.findStudentByRollno(students,3);


