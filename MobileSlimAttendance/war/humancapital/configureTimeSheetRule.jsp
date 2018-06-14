<%@include file="common/common.jsp"%>
<%@include file="common/header.jsp"%>
<script type="text/javascript">

$(document).ready(function(){
	 
		if(${requestScope.actionParam == 'logout'})
		{			 
			var s="To enable new settings, please logout and login again.  "
			if(${requestScope.processDay != null})
				{
					s+="\n Process Day is selected according to End Of Month"
				}
			s+="\n Please click on ok to accept."
			if(confirm(s))
			{
				document.forms[0].action='configureTimeSheetRule';
				document.forms[0].elements['actionParam'].value="logout";
				document.forms[0].submit();
			}
		}
		
	var a=document.forms[0].elements['process_freq'].value;
		
	if(a=="0")
		{
			$("#process_month").show();
			$("#process_week").hide();
		}
	else 
		{	
			$("#process_week").show();
			$("#process_month").hide();
		
		}
		
});


function setDayValue()
{
	var a=document.forms[0].elements['process_freq'].value;
		
	if(a=="0")
		{
			$("#process_month").show();
			$("#process_week").hide();
		}
	else 
		{	
			$("#process_week").show();
			$("#process_month").hide();
		
		}
	
}

</script>

</head>
<%@include file="common/pageUpper.jsp"%>
<div class='controlbox'>
	<form method="post" action="configureTimeSheetRule">
		<input type="hidden" name="actionParam" value="configure">
		<table>
			<tr>
				<td colspan='2' width="50%"><span>Note : After updating the rules, please logout and login again</span></td>
				<td width="30%">&nbsp;</td>
				<td width="20%">&nbsp;</td>

			</tr>
			<tr>
				<td width="30%" align="right"><fmt:message key="flexibel_time" />:</td>
				<td width="20%" align="left"><select name="flexibel_time">

						<option ${f:select("flexibel_time","0")}>Yes</option>
						<option ${f:select("flexibel_time","1")}>No</option>

				</select></td>
				<td width="30%" align="right"><fmt:message
						key="planned_assignment" />:</td>
				<td width="20%" align="left"><select name="planned_assignment">

						<option ${f:select("planned_assignment","1")}>Yes</option>
						<option ${f:select("planned_assignment","0")}>No</option>

				</select></td>
			</tr>

			<tr>
				<td width="30%" align="right"><fmt:message
						key="min_daily_efforts" />:</td>
				<td width="20%" align="left"><select name="min_daily_efforts">
						<option ${f:select("min_daily_efforts","")}>Select</option>
						<option ${f:select("min_daily_efforts","28800")}>8 Hrs 00
							Min</option>
						<option ${f:select("min_daily_efforts","30600")}>8 Hrs 30
							Min</option>
						<option ${f:select("min_daily_efforts","32400")}>9 Hrs 00
							Min</option>
						<option ${f:select("min_daily_efforts","34200")}>9 Hrs 30
							Min</option>
						<option ${f:select("min_daily_efforts","36000")}>10 Hrs
							00 Min</option>
						<option ${f:select("min_daily_efforts","39600")}>11 Hrs
							00 Min</option>
						<option ${f:select("min_daily_efforts","43200")}>12 Hrs
							00 Min</option>
				</select>
				<td width="30%" align="right"><fmt:message
						key="max_daily_efforts" />:</td>
				<td width="20%"><select name="max_daily_efforts">
						<option ${f:select("max_daily_efforts","")}>Select</option>
						<option ${f:select("max_daily_efforts","36000")}>10 Hrs
							00 Min</option>
						<option ${f:select("max_daily_efforts","37800")}>10 Hrs
							30 Min</option>
						<option ${f:select("max_daily_efforts","39600")}>11 Hrs
							00 Min</option>
						<option ${f:select("max_daily_efforts","41400")}>11 Hrs
							30 Min</option>
						<option ${f:select("max_daily_efforts","43200")}>12 Hrs
							00 Min</option>
						<option ${f:select("max_daily_efforts","46800")}>13 Hrs
							00 Min</option>
						<option ${f:select("max_daily_efforts","50400")}>14 Hrs
							00 Min</option>
						<option ${f:select("max_daily_efforts","54000")}>15 Hrs
							00 Min</option>
						<option ${f:select("max_daily_efforts","57600")}>16 Hrs
							00 Min</option>
				</select>
			</tr>

			<tr>
				<td width="30%" align="right"><fmt:message
						key="min_half_day_efforts" />:</td>
				<td width="20%" align="left"><select
					name="min_half_day_efforts">
						<option ${f:select("min_half_day_efforts","")}>Select</option>
						<option ${f:select("min_half_day_efforts","14400")}>4 Hrs
							00 Min</option>
						<option ${f:select("min_half_day_efforts","15300")}>4 Hrs
							15 Min</option>
						<option ${f:select("min_half_day_efforts","16200")}>4 Hrs
							30 Min</option>
						<option ${f:select("min_half_day_efforts","17100")}>4 Hrs
							45 Min</option>
						<option ${f:select("min_half_day_efforts","18000")}>5 Hrs
							00 Min</option>
				</select></td>
				<td width="30%" align="right"><fmt:message
						key="min_half_day_contienous_hrs" />:</td>
				<td width="20%"><select name="min_half_day_contienous_hrs">
						<option ${f:select("min_half_day_contienous_hrs","")}>Select</option>
						<option ${f:select("min_half_day_contienous_hrs","16200")}>4
							Hrs 30 Min</option>
						<option ${f:select("min_half_day_contienous_hrs","17100")}>4
							Hrs 45 Min</option>
						<option ${f:select("min_half_day_contienous_hrs","18000")}>5
							Hrs 00 Min</option>
				</select>
			</tr>
			<tr>
				<td width="30%" align="right"><fmt:message
						key="min_over_time_efforts" />:</td>
				<td width="20%"><select name="min_over_time_efforts">
						<option ${f:select("min_over_time_efforts","")}>Select</option>
						<option ${f:select("min_over_time_efforts","7200")}>2 Hrs
							00 Min</option>
						<option ${f:select("min_over_time_efforts","10800")}>3
							Hrs 00 Min</option>
						<option ${f:select("min_over_time_efforts","14400")}>4
							Hrs 00 Min</option>
				</select></td>
				<td width="30%" align="right"><fmt:message
						key="max_over_time_per_pay_period" />:</td>
				<td width="20%"><select name="max_over_time_per_pay_period">
						<option ${f:select("max_over_time_per_pay_period","")}>Select</option>
						<option ${f:select("max_over_time_per_pay_period","28800")}>8
							Hrs 00 Min</option>
						<option ${f:select("max_over_time_per_pay_period","57600")}>16
							Hrs 00 Min</option>
						<option ${f:select("max_over_time_per_pay_period","108000")}>30
							Hrs 00 Min</option>

				</select></td>
			</tr>

			<tr>
				<td width="30%" align="right"><fmt:message key="lunch_break" />:</td>
				<td width="20%" align="left"><select name="lunch_break">
						<option ${f:select("lunch_break","")}>Select</option>
						<option ${f:select("lunch_break","1800")}>0 Hrs 30 Min</option>
						<option ${f:select("lunch_break","2700")}>0 Hrs 45 Min</option>
						<option ${f:select("lunch_break","3600")}>1 Hrs 00 Min</option>
						<option ${f:select("lunch_break","5400")}>1 Hrs 30 Min</option>
						<option ${f:select("lunch_break","7200")}>2 Hrs 00 Min</option>
						<option ${f:select("lunch_break","9000")}>2 Hrs 30 Min</option>
						<option ${f:select("lunch_break","10800")}>3 Hrs 00 Min</option>
				</select></td>
				<td width="30%" align="right"><fmt:message key="tea_break" />:</td>
				<td width="20%"><select name="tea_break">
						<option ${f:select("tea_break","")}>Select</option>
						<option ${f:select("tea_break","900")}>0 Hrs 15 Min</option>
						<option ${f:select("tea_break","1200")}>0 Hrs 20 Min</option>
						<option ${f:select("tea_break","1800")}>0 Hrs 30 Min</option>
						<option ${f:select("tea_break","2700")}>0 Hrs 45 Min</option>
						<option ${f:select("tea_break","3600")}>1 Hrs 00 Min</option>

				</select></td>
			</tr>

			<tr>
				<td width="30%" align="right"><fmt:message
						key="daily_effort_tolerance" />:</td>
				<td width="20%" align="left"><select
					name="daily_effort_tolerance">
						<option ${f:select("daily_effort_tolerance","")}>Select</option>
						<option ${f:select("daily_effort_tolerance","900")}>0 Hrs
							15 Min</option>
						<option ${f:select("daily_effort_tolerance","1200")}>0
							Hrs 20 Min</option>

				</select></td>
				<td width="30%" align="right"><fmt:message
						key="over_time_tolerance" />:</td>
				<td width="20%"><select name="over_time_tolerance">
						<option ${f:select("over_time_tolerance","")}>Select</option>
						<option ${f:select("over_time_tolerance","900")}>0 Hrs 15
							Min</option>
						<option ${f:select("over_time_tolerance","1200")}>0 Hrs
							20 Min</option>

				</select></td>

			</tr>

			<tr>
				<td width="30%" align="right"><fmt:message
						key="early_in_tolerance" />:</td>
				<td width="20%" align="left"><select name="early_in_tolerance">
						<option ${f:select("early_in_tolerance","")}>Select</option>
						<option ${f:select("early_in_tolerance","900")}>0 Hrs 15
							Min</option>
						<option ${f:select("early_in_tolerance","1200")}>0 Hrs 20
							Min</option>

				</select></td>
				<td width="30%" align="right"><fmt:message
						key="early_left_tolerance" />:</td>
				<td width="20%"><select name="early_left_tolerance">
						<option ${f:select("early_left_tolerance","")}>Select</option>
						<option ${f:select("early_left_tolerance","900")}>0 Hrs
							15 Min</option>
						<option ${f:select("early_left_tolerance","1200")}>0 Hrs
							20 Min</option>
				</select></td>
			</tr>


			<tr>
				<td width="30%" align="right"><fmt:message
						key="late_mark_tolerance" />:</td>
				<td width="20%" align="left"><select name="late_mark_tolerance">
						<option ${f:select("late_mark_tolerance","")}>Select</option>
						<option ${f:select("late_mark_tolerance","900")}>0 Hrs 15
							Min</option>
						<option ${f:select("late_mark_tolerance","1200")}>0 Hrs
							20 Min</option>
				</select></td>
				<td width="30%" align="right"><fmt:message
						key="late_out_tolerance" />:</td>
				<td width="20%"><select name="late_out_tolerance">
						<option ${f:select("late_out_tolerance","")}>Select</option>
						<option ${f:select("late_out_tolerance","900")}>0 Hrs 15
							Min</option>
						<option ${f:select("late_out_tolerance","1200")}>0 Hrs 20
							Min</option>
						<option ${f:select("late_out_tolerance","1800")}>0 Hrs 30
							Min</option>
				</select></td>
			</tr>

			<tr>
				<td width="30%" align="right"><fmt:message
						key="half_day_tolerance" />:</td>
				<td width="20%" align="left"><select name="half_day_tolerance">
						<option ${f:select("half_day_tolerance","")}>Select</option>
						<option ${f:select("half_day_tolerance","900")}>0 Hrs 15
							Min</option>
						<option ${f:select("half_day_tolerance","1200")}>0 Hrs 20
							Min</option>
				</select></td>
				<td width="30%" align="right"><fmt:message
						key="billing_rule" />:</td>
				<td width="20%" align="left"><select name="billing_rule">
						<option ${f:select("billing_rule","")}>Select</option>
						<option ${f:select("billing_rule","1")}>Per Hour Billing
							</option>
						<option ${f:select("billing_rule","2")}>Per Day Billing</option>
						</select>
			</tr>
			<tr>
				<td width="30%" align="right"><fmt:message
						key="department_rule" />:</td>
				<td width="20%" align="left"><select name="department_rule">
						<option ${f:select("department_rule","0")}>Yes</option>
						<option ${f:select("department_rule","1")}>No</option></select>
						</td>
				<td width="30%" align="right">Do you provide Unique employee Id:</td>
				<td width="20%" align="left"><select name="company_uniqueid_rule">
						<option ${f:select("company_uniqueid_rule","0")}>Yes</option>
						<option ${f:select("company_uniqueid_rule","1")}>No</option></select></td>
			</tr>
			<tr>
				<td width="30%" align="right">Do you provide Unique Id to contractors:</td>
				<td width="20%" align="left"><select name="contractor_uniqueid_rule">
						<option ${f:select("contractor_uniqueid_rule","0")}>Yes</option>
						<option ${f:select("contractor_uniqueid_rule","1")}>No</option></select></td>
				<td width="30%" align="right">Payroll Process <div style="float: right;">Frequency</div><br><div style="float: right;margin-top: 5px">Day</div></td>
				<td width="20%" align="left">
				<select name="process_freq" style="width: 90px;" onchange="setDayValue()">
						<option ${f:select("process_freq","0")}>Monthly</option>
						<option ${f:select("process_freq","1")}>Weekly</option>
						</select>
				<br>				
				<div id="process_month" style="display: none;"><select name="process_month" style="width: 90px;">
						<option ${f:select("process_day","1")}>1</option>
						<option ${f:select("process_day","2")}>2</option>
						<option ${f:select("process_day","3")}>3</option>
						<option ${f:select("process_day","4")}>4</option>
						<option ${f:select("process_day","5")}>5</option>
						<option ${f:select("process_day","6")}>6</option>
						<option ${f:select("process_day","7")}>7</option>
						<option ${f:select("process_day","8")}>8</option>
						<option ${f:select("process_day","9")}>9</option>
						<option ${f:select("process_day","10")}>10</option>
						<option ${f:select("process_day","11")}>11</option>
						<option ${f:select("process_day","12")}>12</option>
						<option ${f:select("process_day","13")}>13</option>
						<option ${f:select("process_day","14")}>14</option>
						<option ${f:select("process_day","15")}>15</option>
						<option ${f:select("process_day","16")}>16</option>
						<option ${f:select("process_day","17")}>17</option>
						<option ${f:select("process_day","18")}>18</option>
						<option ${f:select("process_day","19")}>19</option>
						<option ${f:select("process_day","20")}>20</option>
						<option ${f:select("process_day","21")}>21</option>
						<option ${f:select("process_day","22")}>22</option>
						<option ${f:select("process_day","23")}>23</option>
						<option ${f:select("process_day","24")}>24</option>
						<option ${f:select("process_day","25")}>25</option>
						<option ${f:select("process_day","26")}>26</option>
						<option ${f:select("process_day","27")}>27</option>
						<option ${f:select("process_day","28")}>28</option>
						<option ${f:select("process_day","29")}>29</option>
						<option ${f:select("process_day","30")}>30</option>
						<option ${f:select("process_day","31")}>31</option>
						</select></div>
						<div id="process_week" style="display: none;"><select name="process_week" style="width: 90px;">
							<option ${f:select("process_day","1")}>Sunday</option>
							<option ${f:select("process_day","2")}>Monday</option>
							<option ${f:select("process_day","3")}>Tuesday</option>
							<option ${f:select("process_day","4")}>Wednesday</option>
							<option ${f:select("process_day","5")}>Thursday</option>
							<option ${f:select("process_day","6")}>Friday</option>
							<option ${f:select("process_day","7")}>Saturday</option>
						
						</select>
						</div>
						
						
						</td>
						
						
			
			</tr>
			<tr>
				<td colspan="4" align="center"><input type="submit"
					value="Update" name="Create" title="Create"
					class="select1" onclick="return updateTimeSheetRules();"> <input type="button" value="Reset"
					name="Reset" title="Reset" class="select1"></td>
			</tr>

		</table>
		<input type="hidden" ${f:hidden("companyId")} id="companyId">
	</form>
</div>
<%@include file="common/footer.jsp"%>