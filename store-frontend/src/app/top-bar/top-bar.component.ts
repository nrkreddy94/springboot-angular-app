import { Component, OnInit } from '@angular/core';
import { TimeService } from '../time.service';


@Component({
  selector: 'app-top-bar',
  templateUrl: './top-bar.component.html',
  styleUrls: ['./top-bar.component.css'],
})
export class TopBarComponent implements OnInit {

  logo =  "/store/assets/images/logo.png";
  currentTime: string = '';
  constructor(private timeService: TimeService) {}
  ngOnInit() {
    this.timeService.getCurrentTime().subscribe((res) => {
      this.currentTime = res.currentTime;
    });
  }
}
